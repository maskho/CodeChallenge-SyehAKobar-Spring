package com.agen.pariwisata.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "agen")
@Data
public class Agen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;
    private String kontak;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Reservasi.class)
    @JoinColumn(name = "agen_id",referencedColumnName = "id")
    private List<Reservasi> reservasis;
}
