package org.example.web.mapper;

import org.example.model.DataGenerator;
import org.example.web.dto.DataGeneratorDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<DataGenerator, DataGeneratorDto> {


}
