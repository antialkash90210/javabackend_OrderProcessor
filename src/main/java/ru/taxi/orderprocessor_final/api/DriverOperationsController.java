
package ru.taxi.orderprocessor_final.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.taxi.orderprocessor_final.dto.DriverDto;
import ru.taxi.orderprocessor_final.entity.DriverEntity;
import ru.taxi.orderprocessor_final.logic.DriverOperationsService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/drivers") //драйверы
public class DriverOperationsController { //Контроллер операций с драйверами

    private final DriverOperationsService driverOperationsService;

    //Создайте
    @PostMapping
    public DriverEntity create(@RequestBody DriverDto dto) {
        return driverOperationsService.create(dto);
    }
}
