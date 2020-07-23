package com.carrent.dao.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {


    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;



}
