package com.agen.pariwisata.controller;

import com.agen.pariwisata.model.Reservasi;
import com.agen.pariwisata.repository.ReservasiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservasiController {
    @Autowired
    private ReservasiRepo reservasiRepo;

    @GetMapping("/reservasi")
    public List<Reservasi> getReservasi() {
        return reservasiRepo.findAll();
    }
    @GetMapping("/reservasi/total")
    public Integer getTotal(){
        List<Reservasi> reservasis = reservasiRepo.findAll();
        return reservasis.size();
    }

}
