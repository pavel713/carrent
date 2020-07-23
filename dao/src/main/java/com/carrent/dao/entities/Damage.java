package com.carrent.dao.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "damage")
public class Damage extends BaseEntity {


    @Column(name = "contract_id")
    private String contract;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "result")
    private String result;




}
