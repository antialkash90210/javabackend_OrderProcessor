
package ru.taxi.orderprocessor_final.logic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.taxi.orderprocessor_final.dto.CarCreateUpdateOperationDto;
import ru.taxi.orderprocessor_final.enums.PriorityClass;

import java.time.LocalDate;
import java.time.Period;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarOperationsProcessor { //Процессор управления автомобилем

    @Value("${internal.cars.max-year}")
    private Integer maxYear; //макс Год
    @Value("${internal.cars.offset}")
    private Integer offset; //компенсировать

    //Рассчитать
    public PriorityClass doCalculateClass(CarCreateUpdateOperationDto dto) {
        var between = Period.between(LocalDate.now(), dto.getIssuedAt());
        var carAge = between.getYears();
        if (carAge > maxYear) {
            throw new IllegalStateException("Exceeded allowed time period for car exploitation!");
            //Превышен разрешенный срок эксплуатации автомобиля!
        }
        //необработанный приоритетный класс
        PriorityClass rawPriorityClass = PriorityClass.convert(dto.getCarClass());
        Integer downgradesToApply = doCalculateDowngrades(carAge); //переход на более раннюю версию Подать заявку

        rawPriorityClass = downgradesToApply > rawPriorityClass.ordinal() ?
                PriorityClass.values()[0] :
                PriorityClass.values()[rawPriorityClass.ordinal() - downgradesToApply];

        return rawPriorityClass;
    }

    //Рассчитать понижение
    public Integer doCalculateDowngrades(Integer carAge) {
        int downgrades = carAge / offset;
        int tail = carAge % offset;
        if (tail == 0) {
            downgrades -= 1;
        }
        return downgrades;
    }
}
