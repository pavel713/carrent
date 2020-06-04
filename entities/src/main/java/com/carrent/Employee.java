package com.carrent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity{




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "employee")
    @Getter
    @Setter
    private Set<Contract> contracts = new HashSet<>();



}
