package com.agen.pariwisata.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class BookingRes {
    private String nama;
    private String alamat;
    private String destinasi;
    private Date tgl_berangkat;

    public BookingRes(String nama, String alamat, String destinasi, Date tgl_berangkat) {
        this.nama = nama;
        this.alamat = alamat;
        this.destinasi = destinasi;
        this.tgl_berangkat = tgl_berangkat;
    }
}
