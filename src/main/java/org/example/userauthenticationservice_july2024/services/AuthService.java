package org.example.userauthenticationservice_july2024.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.MacAlgorithm;
import org.antlr.v4.runtime.misc.Pair;
import org.example.userauthenticationservice_july2024.exceptions.InvalidCredentialsException;
import org.example.userauthenticationservice_july2024.exceptions.UserAlreadyExistsException;
import org.example.userauthenticationservice_july2024.models.State;
import org.example.userauthenticationservice_july2024.models.User;
import org.example.userauthenticationservice_july2024.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private UserRepo userRepo;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User signup(String email, String password) throws UserAlreadyExistsException {
        Optional<User> userOptional = userRepo.findUserByEmail(email);
        if(userOptional.isPresent()) {
            throw new UserAlreadyExistsException("Email already registered !!");
        }

        User user = new User();

        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setState(State.ACTIVE);
        userRepo.save(user);
        return user;
    }

    @Override
    public Pair<User,MultiValueMap<String,String>> login(String email, String password) throws InvalidCredentialsException {
        Optional<User> userOptional = userRepo.findUserByEmail(email);

        if(userOptional.isPresent()) {
            User user = userOptional.get();
            if(!bCryptPasswordEncoder.matches(password,user.getPassword())) {
              throw new InvalidCredentialsException("please provide correct password");
            }

//            String message = "{\n" +
//                "   \"email\": \"anurag@scaler.com\",\n" +
//                "   \"roles\": [\n" +
//                "      \"instructor\",\n" +
//                "      \"buddy\"\n" +
//                "   ],\n" +
//                "   \"expirationDate\": \"25thSept2024\"\n" +
//                "}";
//
//            byte[] content = message.getBytes(StandardCharsets.UTF_8);

            Map<String,Object> claims =new HashMap<>();
            claims.put("user_id__",user.getId());
            //claims.put("user_email",user.getEmail());
            claims.put("roles",user.getRole());
            long timeInMillis = System.currentTimeMillis();
            claims.put("iat",timeInMillis);
            claims.put("exp",timeInMillis+86400000);
            claims.put("iss","anuragkhanna");


            MacAlgorithm algorithm = Jwts.SIG.HS256;
            SecretKey secretKey = algorithm.key().build();
            String token = Jwts.builder().claims(claims).signWith(secretKey).compact();

            MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
            headers.add(HttpHeaders.SET_COOKIE,token);

            Pair<User,MultiValueMap<String,String>> p = new Pair<>(user,headers);

            return p;
        }

        return null;
    }

    @Override
    public User logout(String email) {
        return null;
    }
}

//token validation
// -- persist token
// -- token which i have got as parameter, same token is also stored with me
// -- destruct token , get payload -> from payload , get exp and then decide whether expired or not