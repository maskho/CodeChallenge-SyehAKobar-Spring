package com.agen.pariwisata.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class BookingRes {
    private Long id_customer;
    private String nama;
    private String alamat;
    private Long id_reservasi;
    private String destinasi;
    private Date tgl_berangkat;

    public BookingRes(String nama, String alamat, String destinasi, Date tgl_berangkat, Long id_customer, Long id_reservasi) {
        this.nama = nama;
        this.alamat = alamat;
        this.destinasi = destinasi;
        this.tgl_berangkat = tgl_berangkat;
        this.id_customer=id_customer;
        this.id_reservasi=id_reservasi;
    }
}
