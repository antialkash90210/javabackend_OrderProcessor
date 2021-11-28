
package ru.taxi.orderprocessor_final.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.taxi.orderprocessor_final.dto.DriverDto;
import ru.taxi.orderprocessor_final.entity.DriverEntity;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DriverMapper {

    DriverEntity map(DriverDto dto);
}
