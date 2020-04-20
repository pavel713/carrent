package com.carrent;


import java.sql.Date;
import java.util.Objects;


public class Contract {
    private long id;
    private Date date_begin;
    private Date date_end;
    private int client_id;
    private int car_id;
    private int employee;


    public Contract(int id, Date date_begin, Date date_end, int car_id, int client_id) {
        this.id = id;
        this.date_begin = date_begin;
        this.date_end = date_end;
        this.car_id = car_id;
        this.client_id = client_id;
    }

    public Contract() {

    }

    public Contract(int id, Date date_begin, Date date_end, int clientID, int car_id, int employee) {
    }

    public Contract(int id, int contract_id, Date date, String result) {

    }

    public Contract(int id, String name, int phone) {

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_begin() {
        return date_begin;
    }

    public void setDate_begin(Date date_begin) {
        this.date_begin = date_begin;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return id == contract.id &&
                client_id == contract.client_id &&
                car_id == contract.car_id &&
                employee == contract.employee &&
                Objects.equals(date_begin, contract.date_begin) &&
                Objects.equals(date_end, contract.date_end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date_begin, date_end, client_id, car_id, employee);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", date_begin=" + date_begin +
                ", date_end=" + date_end +
                ", client_id=" + client_id +
                ", car_id=" + car_id +
                ", employee=" + employee +
                '}';
    }
}

