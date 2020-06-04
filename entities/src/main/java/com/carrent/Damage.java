package com.carrent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;



@NoArgsConstructor
@Entity
@Table(name = "damage")
public class Damage extends BaseEntity{

    public Damage(LocalDate date, String result, Contract contract) {
        this.date = date;
        this.result = result;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    @Setter
    @Column(name = "contract_id")
    private String contract;

    @Getter
    @Setter
    @Column(name = "date")
    private LocalDate date;

    @Getter
    @Setter
    @Column(name = "result")
    private String result;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contract_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    @Getter
    @Setter
    private Contract contracts;


}
