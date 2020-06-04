package com.carrent;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@Entity
@Table(name = "contract")
public class Contract extends BaseEntity {

    public Contract(LocalDate date_begin, LocalDate date_end, int client_id, int employee, Car car) {
        this.date_begin = date_begin;
        this.date_end = date_end;


        this.car = car;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    @Setter
    @Column(name = "date_begin")
    private LocalDate date_begin;

    @Getter
    @Setter
    @Column(name = "date_end")
    private LocalDate date_end;


    @OneToMany(mappedBy = "contract")
    @Getter
    @Setter
    private Set<Client> clients = new HashSet<>();

    @OneToMany(mappedBy = "contract")
    @Getter
    @Setter
    private Set<Damage> damages = new HashSet<>();


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    @Getter
    @Setter
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee", nullable = false)
    @Fetch(FetchMode.JOIN)
    @Getter
    @Setter
    private Employee employee;


}

