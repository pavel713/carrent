package com.carrent.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "damage")
public class Damage extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "contract_id")
    private String contract;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "result")
    private String result;




}
