package com.prokat.entity;

import javax.persistence.Table;
import java.util.Objects;


public class Client {
    private long id;
    private String name;
    private String passport;
    private String address;
    private int phone;
    private String password;




    public Client(String name, String password) {
    }

    public Client() {

    }

    public Client(String name, String passport, String address, int phone, String password) {

        this.name = name;
        this.passport = passport;
        this.address = address;
        this.phone = phone;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                phone == client.phone &&
                Objects.equals(name, client.name) &&
                Objects.equals(passport, client.passport) &&
                Objects.equals(address, client.address) &&
                Objects.equals(password, client.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, passport, address, phone, password);
    }
}
