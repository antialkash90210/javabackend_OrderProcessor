
package ru.taxi.orderprocessor_final.entity;

public class RouteEntity extends BaseEntity {

    private Point from;
    private Point to;


    public static class Point {

        private Double lat;
        private Double lng;
    }
}