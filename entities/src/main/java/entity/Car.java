package com.prokat.entity;

import java.util.Objects;

public class Car {
    private long id;
    private String model;
    private String color;
    private boolean rented;
    private String plate_num;
    private int year;
    private int price;




    public Car(String model, String color, boolean rented, String plate_num, int year, int price) {

        this.model = model;
        this.color = color;
        this.rented = rented;
        this.plate_num = plate_num;
        this.year = year;
        this.price = price;
    }

    public Car(String model, String color, String plate_num, int year, int price) {
        this.model = model;
        this.color = color;
        this.plate_num = plate_num;
        this.year = year;
        this.price = price;
    }

    public Car() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public String getPlate_num() {
        return plate_num;
    }

    public void setPlate_num(String plate_num) {
        this.plate_num = plate_num;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                rented == car.rented &&
                year == car.year &&
                price == car.price &&
                Objects.equals(model, car.model) &&
                Objects.equals(color, car.color) &&
                Objects.equals(plate_num, car.plate_num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, color, rented, plate_num, year, price);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", rented=" + rented +
                ", plate_num='" + plate_num + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
