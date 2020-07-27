package com.agen.pariwisata.repository;

import com.agen.pariwisata.model.Agen;
import com.agen.pariwisata.model.dto.PaketWisataRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgenRepo extends JpaRepository<Agen, Long> {
    @Query("select new com.agen.pariwisata.model.dto.PaketWisataRes(a.nama,a.kontak,r.destinasi, a.id) from Agen a join a.reservasis r where a.nama=?1")
    List<PaketWisataRes> findByNama(String nama);

    @Query("select new com.agen.pariwisata.model.dto.PaketWisataRes(a.nama,a.kontak,r.destinasi,a.id) from Agen a join a.reservasis r")
    List<PaketWisataRes> getJoinInfo();
}
