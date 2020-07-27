package com.agen.pariwisata.controller;

import com.agen.pariwisata.exception.DataNotFoundException;
import com.agen.pariwisata.model.Agen;
import com.agen.pariwisata.model.dto.PaketWisataReq;
import com.agen.pariwisata.model.dto.PaketWisataRes;
import com.agen.pariwisata.repository.AgenRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgenController {
    private AgenRepo agenRepo;

    @PostMapping("/agen")
    public Agen newAgen(@RequestBody PaketWisataReq req) {
        return agenRepo.save(req.getAgen());
    }

    @GetMapping("/agen/all")
    public List<PaketWisataRes> getJoinInfo() {
        return agenRepo.getJoinInfo();
    }

    @GetMapping("/agen")
    public List<PaketWisataRes> getAgen(String nama) {
        if (agenRepo.findByNama(nama).isEmpty()) {
            throw new DataNotFoundException(nama);
        }
        return agenRepo.findByNama(nama);
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
