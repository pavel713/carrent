package com.carrent.dao.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@NoArgsConstructor
@Entity
@Table(name = "contract")
@Getter
@Setter
public class Contract extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "date_begin")
    private LocalDate date_begin;

    @Column(name = "date_end")
    private LocalDate date_end;









}

