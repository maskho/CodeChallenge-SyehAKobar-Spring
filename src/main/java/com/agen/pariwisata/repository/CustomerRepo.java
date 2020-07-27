package com.agen.pariwisata.repository;

import com.agen.pariwisata.model.Customer;
import com.agen.pariwisata.model.dto.BookingRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
    @Query("select new com.agen.pariwisata.model.dto.BookingRes(c.nama, c.alamat, r.destinasi, r.tgl_berangkat) from Customer c join c.reservasis r")
    public List<BookingRes> getJoinInfo();
}
