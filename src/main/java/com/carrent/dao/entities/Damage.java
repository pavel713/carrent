package com.carrent.dao.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "damage")
public class Damage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "result")
    private String result;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

}
