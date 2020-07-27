package com.agen.pariwisata.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservasi")
@Data
public class Reservasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "default '2000-10-10'")
    private Date tgl_berangkat;

    private String destinasi;

}
