package com.agen.pariwisata.controller;

import com.agen.pariwisata.exception.DataNotFoundException;
import com.agen.pariwisata.model.Reservasi;
import com.agen.pariwisata.repository.ReservasiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservasiController {
    @Autowired
    private ReservasiRepo reservasiRepo;

    @GetMapping("/reservasi/all")
    public List<Reservasi> getReservasiAll() {
        return reservasiRepo.findAll();
    }

    @GetMapping("/reservasi/{id}")
    public Reservasi getReservasi(@PathVariable Long id) {
        return reservasiRepo.findById(id).orElseThrow(() -> new DataNotFoundException(id));
    }

    @GetMapping("/reservasi/total")
    public Integer getTotal() {
        List<Reservasi> reservasis = reservasiRepo.findAll();
        return reservasis.size();
    }

    @PutMapping("/reservasi/{id}")
    public Reservasi editReservasi(@PathVariable Long id,
                                   @RequestBody Reservasi req) {
        Reservasi reservasi = reservasiRepo.findById(id).
                orElseThrow(() -> new DataNotFoundException(id));
        reservasi.setDestinasi(req.getDestinasi());
        reservasi.setTgl_berangkat(req.getTgl_berangkat());
        return reservasiRepo.save(reservasi);
    }

    @DeleteMapping("/reservasi/{id}")
    public ResponseEntity<?> delReservasi(@PathVariable Long id) {
        return reservasiRepo.findById(id)
                .map(reservasi -> {
                    reservasiRepo.delete(reservasi);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new DataNotFoundException(id));
    }
}
