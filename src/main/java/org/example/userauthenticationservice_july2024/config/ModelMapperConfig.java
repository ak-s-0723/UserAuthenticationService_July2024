package org.example.userauthenticationservice_july2024.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    private final MatchingStrategy STRICT_MATCHING_STRATEGY = MatchingStrategies.STRICT;

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(STRICT_MATCHING_STRATEGY)
                .setPropertyCondition(context -> context.getSource() != null);
        return modelMapper;
    }
}
