package com.agen.pariwisata.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String nama;
    private String alamat;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Reservasi.class)
    @JoinColumn(name = "cust_id",referencedColumnName = "id")
    private List<Reservasi> reservasis;
}
