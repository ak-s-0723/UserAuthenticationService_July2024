package org.example.userauthenticationservice_july2024.mappers;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;

@Getter
@Setter
@Component
public abstract class EntityMapper<D, E> {

    @Autowired
    private ModelMapper modelMapper;

    private final Class<D> dtoClass = (Class<D>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    private final Class<E> entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];

    public D toDto(E entity) {
        return this.getModelMapper().map(entity, this.getDtoClass());
    }

    public E toEntity(D dto) {
        return this.getModelMapper().map(dto, this.getEntityClass());
    }

    public E createEntity(D dto) {
        return this.toEntity(dto);
    }

    public E mergeEntity(D sourceDto, E destinationEntity) {
        this.getModelMapper().map(sourceDto, destinationEntity);
        return destinationEntity;
    }

    public E replaceEntity(D dto, E entity) {
        return this.createEntity(dto);
    }
}
