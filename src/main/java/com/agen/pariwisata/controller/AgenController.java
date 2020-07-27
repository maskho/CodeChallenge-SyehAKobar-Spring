package com.agen.pariwisata.controller;

import com.agen.pariwisata.model.Agen;
import com.agen.pariwisata.model.dto.PaketWisataReq;
import com.agen.pariwisata.model.dto.PaketWisataRes;
import com.agen.pariwisata.repository.AgenRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgenController {
    private AgenRepo agenRepo;

    @PostMapping("/agen")
    public Agen newAgen(@RequestBody PaketWisataReq req){
        return agenRepo.save(req.getAgen());
    }
    @GetMapping("/agen")
    public List<PaketWisataRes> getJoinInfo(){
        return agenRepo.getJoinInfo();
    }
}
