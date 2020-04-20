package com.carrent;

import java.sql.Date;
import java.util.Objects;

public class Damage {
    private long id;
    private int contract_id;
    private Date date;
    private String result;

    public Damage() {
        this.id = id;
        this.contract_id = contract_id;
        this.date = date;
        this.result = result;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Damage damage = (Damage) o;
        return id == damage.id &&
                contract_id == damage.contract_id &&
                Objects.equals(date, damage.date) &&
                Objects.equals(result, damage.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contract_id, date, result);
    }

    @Override
    public String toString() {
        return "Damage{" +
                "id=" + id +
                ", contract_id=" + contract_id +
                ", date=" + date +
                ", result='" + result + '\'' +
                '}';
    }
}
