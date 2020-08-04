package com.carrent.dao.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "damage")
public class Damage extends BaseEntity {

    @Column(name = "date")
    private LocalDate date;


    @Column(name = "result")
    private String result;

    @OneToOne(mappedBy = "damage")
    private Order order;

}
