package com.agen.pariwisata.controller;

import com.agen.pariwisata.exception.DataNotFoundException;
import com.agen.pariwisata.model.Agen;
import com.agen.pariwisata.model.dto.PaketWisataReq;
import com.agen.pariwisata.model.dto.PaketWisataRes;
import com.agen.pariwisata.repository.AgenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgenController {
    @Autowired
    private AgenRepo agenRepo;

    @PostMapping("/agen")
    public Agen newAgen(@RequestBody PaketWisataReq req) {

        return agenRepo.save(req.getAgen());
    }

    @GetMapping("/agen/all")
    public List<PaketWisataRes> getJoinInfo() {
        return agenRepo.getJoinInfo();
    }

    // GET QUERY PARAM
    // localhost:8080/agen?nama=Nama Agen
    @GetMapping("/agen")
    public List<PaketWisataRes> getAgen(String nama) {
        if (agenRepo.findByNama(nama).isEmpty()) {
            throw new DataNotFoundException(nama);
        }
        return agenRepo.findByNama(nama);
    }
    @PutMapping("/agen/{id}")
    public Agen editAgen(@PathVariable Long id,
                         @RequestBody Agen req){
        Agen agen = agenRepo.findById(id)
                .orElseThrow(()->new DataNotFoundException(id));
        agen.setNama(req.getNama());
        agen.setKontak(req.getKontak());
        return agenRepo.save(agen);
    }

    @DeleteMapping("/agen/{id}")
    public ResponseEntity<?> delBarang(@PathVariable Long id) {
        return agenRepo.findById(id)
                .map(agen -> {
                    agenRepo.delete(agen);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new DataNotFoundException(id));
    }
}
