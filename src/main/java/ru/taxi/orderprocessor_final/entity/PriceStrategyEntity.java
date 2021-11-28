
package ru.taxi.orderprocessor_final.entity;

import ru.taxi.orderprocessor_final.enums.PriorityClass;

public class PriceStrategyEntity extends BaseEntity {

    private PriorityClass priorityClass;
    private TariffEntity tariff;
    private Double waitTimePrice;

    private Double totalPrice; //calculated

}