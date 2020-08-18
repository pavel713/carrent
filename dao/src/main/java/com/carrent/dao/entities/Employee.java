package com.carrent.dao.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Order order;
}
