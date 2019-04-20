package com.wap.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public abstract class BaseDto<TEntity, TDto> {


    private int id;

    protected Class<TEntity> typeTEntoty;
    protected Class<TDto> typeTdto;


    public TEntity toEntity() {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, typeTEntoty);

    }

    public TDto toDto(TEntity entity) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, typeTdto);

    }


}
