
package ru.taxi.orderprocessor_final.entity;

public class RateEntity extends BaseEntity {

    private Integer rate;
    private RateDetails rateDetails;
    private String extFeedback;


    public enum RateDetails {
        POLITE_DRIVER,
        BEST_DRIVER,
        TRIP_COMFORT,
        COMFORT_MUSIC
    }
}