
package ru.taxi.orderprocessor_final.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.taxi.orderprocessor_final.entity.CarEntity;
import ru.taxi.orderprocessor_final.enums.PriorityClass;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {

    private String model;
    private String stateNumber;
    private String color;
    private LocalDate issuedAt;
    private CarEntity.CarClass carClass;
    private PriorityClass priorityClass;
}