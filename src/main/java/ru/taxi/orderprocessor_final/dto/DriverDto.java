
package ru.taxi.orderprocessor_final.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.taxi.orderprocessor_final.entity.DriverEntity;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DriverDto {

    private String firstName;
    private String secondName;
    private String licenseNumber;
    private Integer drivingExp;
    private DriverEntity.DriverStatus status;
    private boolean terminated;
    private String carNumber;
}