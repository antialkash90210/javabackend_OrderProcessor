
package ru.taxi.orderprocessor_final.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.taxi.orderprocessor_final.dto.CarCreateUpdateOperationDto;
import ru.taxi.orderprocessor_final.dto.CarDto;
import ru.taxi.orderprocessor_final.entity.CarEntity;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CarMapper { //автомобиль на карте

    @Mapping(source = "stateNumber", target = "number")
    @Mapping(target = "priorityClass", ignore = true)
    CarEntity dtoToEntity(CarCreateUpdateOperationDto carCreateUpdateOperationDto);

    @Mapping(source = "number", target = "stateNumber")
    CarDto entityToDto(CarEntity carEntity);

    CarEntity updateFromDto(CarCreateUpdateOperationDto source, @MappingTarget CarEntity target);

    List<CarDto> entityToDto(Collection<CarEntity> target);
}