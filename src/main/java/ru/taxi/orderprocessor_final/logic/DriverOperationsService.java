
package ru.taxi.orderprocessor_final.logic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.taxi.orderprocessor_final.dao.DriverOperationsRepository;
import ru.taxi.orderprocessor_final.dto.DriverDto;
import ru.taxi.orderprocessor_final.entity.DriverEntity;
import ru.taxi.orderprocessor_final.mapper.DriverMapper;

@Slf4j
@Service
@RequiredArgsConstructor
public class DriverOperationsService { //Служба эксплуатации водителей

    private final DriverOperationsRepository driverOperationsRepository;
    private final CarOperationsService carOperationsService;
    private final DriverMapper driverMapper;

    public DriverEntity create(DriverDto dto) {
        DriverEntity driverEntity = driverMapper.map(dto);
        var car = carOperationsService.findByNumberInternal(dto.getCarNumber());
        driverEntity.setCar(car);
        return driverOperationsRepository.save(driverEntity);
    }
}
