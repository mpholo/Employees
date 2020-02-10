package com.mpholo.learning.employees.mapper;


import com.mpholo.learning.employees.DTO.TitleDTO;
import com.mpholo.learning.employees.models.Title;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TitleMapper {


    TitleMapper INSTANCE = Mappers.getMapper(TitleMapper.class);

    TitleDTO titleToTitleDTO(Title title);


}
