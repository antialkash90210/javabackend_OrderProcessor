
package ru.taxi.orderprocessor_final.logic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.taxi.orderprocessor_final.dao.CarOperationsRepository;
import ru.taxi.orderprocessor_final.dao.custom.CarOperationsRepositoryCustom;
import ru.taxi.orderprocessor_final.dto.CarCreateUpdateOperationDto;
import ru.taxi.orderprocessor_final.dto.CarDto;
import ru.taxi.orderprocessor_final.dto.FindCarsCriteria;
import ru.taxi.orderprocessor_final.entity.CarEntity;
import ru.taxi.orderprocessor_final.enums.PriorityClass;
import ru.taxi.orderprocessor_final.mapper.CarMapper;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarOperationsService { //Служба эксплуатации автомобилей

    private final CarOperationsRepository repository;
    private final CarOperationsRepositoryCustom repositoryCustom;
    private final CarOperationsProcessor processor;
    private final CarMapper mapper;

    //Создать
    public CarDto create(CarCreateUpdateOperationDto dto) {
        log.debug("create.in - dto {}", dto);
        var carEntity = mapper.dtoToEntity(dto);
        PriorityClass priorityClass = processor.doCalculateClass(dto);
        carEntity.setPriorityClass(priorityClass);
        log.info("create.in - calculated priority class: {}", priorityClass);
        var createdCar = repository.save(carEntity);
        log.info("create.out - created car_entity with id {}", createdCar.getId());
        var carDto = mapper.entityToDto(createdCar);
        log.debug("create.out - response {}", carDto);
        return carDto;
    }
    //Обновить
    public CarDto update(CarCreateUpdateOperationDto dto) {
        log.debug("update.in - dto {}", dto);
        var stateNumber = dto.getStateNumber();
        var carEntity = findByNumberInternal(stateNumber);
        log.info("update.in - found car record with number {}", stateNumber);
        var entityUpdated = mapper.updateFromDto(dto, carEntity);

        PriorityClass priorityClass = processor.doCalculateClass(dto);
        entityUpdated.setPriorityClass(priorityClass);

        var updatedPersisted = repository.save(entityUpdated);
        log.info("update.in - car record with number {} updated", stateNumber);
        var updatedPersistedDto = mapper.entityToDto(updatedPersisted);
        log.debug("update.out - response {}", updatedPersistedDto);
        return updatedPersistedDto;
    }
    //Найти
    public List<CarDto> find(FindCarsCriteria criteria) {
        log.info("find.in - searching cars by criteria {}", criteria);
        List<CarEntity> carEntities = repositoryCustom.find(criteria.getCriteria(), criteria.getSort());
        var carDtos = mapper.entityToDto(carEntities);
        log.info("find.out - result: {}", carDtos);
        return carDtos;
    }
    //Найти по номеру
    public CarDto findByNumber(String stateNumber) {
        return mapper.entityToDto(findByNumberInternal(stateNumber));
    }
    //найти по внутр номеру
    public CarEntity findByNumberInternal(String stateNumber) {
        return repository.findByNumber(stateNumber).orElseThrow(() -> {
            throw new EntityNotFoundException(format("Car with number %s not found in registry.", stateNumber));
        });
    }

}