
package ru.taxi.orderprocessor_final.enums;

import ru.taxi.orderprocessor_final.entity.CarEntity;


/**
 * Do not change order!
 */

//TODO move to DB
public enum PriorityClass {
    STANDARD,
    COMFORT,
    COMFORT_PLUS,
    BLACK;

    public static PriorityClass convert(CarEntity.CarClass carClass) {
        switch (carClass) {
            case A:
            case B:
                return PriorityClass.STANDARD;
            case C:
                return PriorityClass.COMFORT;
            case D:
                return PriorityClass.COMFORT_PLUS;
            case E:
            case F:
                return PriorityClass.BLACK;
            default:
                throw new IllegalArgumentException("Invalid enum args passed!");
        }
    }
}