package com.agen.pariwisata.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class PaketWisataRes {
    private String destinasi;
    private String agen;
    private String kontak;

    public PaketWisataRes(String agen, String kontak, String destinasi) {
        this.destinasi = destinasi;
        this.agen = agen;
        this.kontak = kontak;
    }
}
