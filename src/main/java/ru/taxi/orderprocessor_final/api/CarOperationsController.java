
package ru.taxi.orderprocessor_final.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.taxi.orderprocessor_final.dto.CarCreateUpdateOperationDto;
import ru.taxi.orderprocessor_final.dto.CarDto;
import ru.taxi.orderprocessor_final.dto.FindCarsCriteria;
import ru.taxi.orderprocessor_final.logic.CarOperationsService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarOperationsController {

    private final CarOperationsService carOperationsService;

    @PostMapping
    public CarDto createCar(@Valid @RequestBody CarCreateUpdateOperationDto carCreateUpdateOperationDto) {
        log.debug("createCar.in - dto: {}", carCreateUpdateOperationDto);
        var carEntity = carOperationsService.create(carCreateUpdateOperationDto);
        log.debug("createCar.out - response: {}", carEntity);
        return carEntity;
    }

    @PutMapping
    public CarDto updateCar(@Valid @RequestBody CarCreateUpdateOperationDto carDto) {
        log.debug("updateCar.in - dto: {}", carDto);
        var carEntity = carOperationsService.update(carDto);
        log.debug("updateCar.out - response: {}", carEntity);
        return carEntity;
    }

    @GetMapping("/{number}")
    public CarDto findCarByNumber(@PathVariable String number) {
        return carOperationsService.findByNumber(number);
    }

    @PostMapping("/find")
    public List<CarDto> findCars(@RequestBody @Valid FindCarsCriteria findCarsCriteria) {
        return carOperationsService.find(findCarsCriteria);
    }

}