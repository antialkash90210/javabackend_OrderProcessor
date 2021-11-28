
package ru.taxi.orderprocessor_final.entity;

public class OrderEntity extends BaseEntity {

    private DriverEntity driver;
    private ClientEntity client;

    private PriceStrategyEntity priceStrategy;
    private RateEntity rateEntity;

    private OrderStatus status;

    public enum OrderStatus {
        CREATED,
        DRIVER_WAITING,
        CLIENT_WAITING,
        IN_PROGRESS,
        FINISHED
    }
}