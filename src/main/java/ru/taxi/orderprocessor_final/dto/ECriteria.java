
package ru.taxi.orderprocessor_final.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.taxi.orderprocessor_final.entity.CarEntity;
import ru.taxi.orderprocessor_final.enums.PriorityClass;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ECriteria {

    private CarEntity.CarClass carClass;
    private String color;
    private PriorityClass priorityClass;
    private LocalDate issuedAtGreater;
    private LocalDate issuedAtLower;
    private String model;
}