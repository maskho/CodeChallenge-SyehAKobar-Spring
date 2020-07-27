package com.agen.pariwisata.controller;

import com.agen.pariwisata.model.Customer;
import com.agen.pariwisata.model.dto.BookingReq;
import com.agen.pariwisata.model.dto.BookingRes;
import com.agen.pariwisata.repository.CustomerRepo;
import com.agen.pariwisata.repository.ReservasiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ReservasiRepo reservasiRepo;

    // POST JSON example:
    //    {"customer":{
    //     "nama":"Barbar Darsono",
    //     "alamat":"Jalan Sesama, Surabaya",
    //     "reservasis":[{
    //          "tgl_berangkat":"2020-10-10",
    //          "destinasi":"Samosir"
    //        }]
    //    }}
    @PostMapping("/booking")
    public Customer newCustomer(@RequestBody BookingReq req) {
        return customerRepo.save(req.getCustomer());
    }
    @GetMapping("/customer")
    public List<BookingRes> getJoinInfo(){
        return customerRepo.getJoinInfo();
    }
}
