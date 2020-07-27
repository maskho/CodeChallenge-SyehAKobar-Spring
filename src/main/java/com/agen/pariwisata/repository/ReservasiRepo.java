package com.agen.pariwisata.repository;

import com.agen.pariwisata.model.Reservasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservasiRepo extends JpaRepository<Reservasi,Long> {
}
