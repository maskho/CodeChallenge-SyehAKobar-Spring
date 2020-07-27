package com.agen.pariwisata.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class PaketWisataRes {
    private String destinasi;
    private Long id_agen;
    private String agen;
    private String kontak;

    public PaketWisataRes(String agen, String kontak, String destinasi, Long id_agen) {
        this.destinasi = destinasi;
        this.id_agen = id_agen;
        this.agen = agen;
        this.kontak = kontak;
    }
}
