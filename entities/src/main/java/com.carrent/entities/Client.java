package com.carrent.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "name")
    private String name;

    @Column(name = "passport")
    private String passport;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;






}
