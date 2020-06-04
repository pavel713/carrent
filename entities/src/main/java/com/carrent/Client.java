package com.carrent;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@NoArgsConstructor
@Entity
@Table(name = "client")

public class Client extends BaseEntity{


    public Client(String passport, String address, String phone) {
        this.passport = passport;
        this.address = address;
        this.phone = phone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "passport")
    private String passport;

    @Getter
    @Setter
    @Column(name = "address")
    private String address;

    @Getter
    @Setter
    @Column(name = "phone")
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contract_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    @Getter
    @Setter
    private Contract contract;


}
