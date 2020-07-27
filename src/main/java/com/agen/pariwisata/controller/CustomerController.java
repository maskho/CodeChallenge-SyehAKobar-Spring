package com.agen.pariwisata.controller;

import com.agen.pariwisata.exception.DataNotFoundException;
import com.agen.pariwisata.model.Customer;
import com.agen.pariwisata.model.Reservasi;
import com.agen.pariwisata.model.dto.BookingReq;
import com.agen.pariwisata.model.dto.BookingRes;
import com.agen.pariwisata.repository.CustomerRepo;
import com.agen.pariwisata.repository.ReservasiRepo;
import com.agen.pariwisata.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ReservasiRepo reservasiRepo;
    @Autowired
    private ModelMapperUtil modelMapperUtil;

    // POST JSON example:
    //    {"customer":{
    //     "nama":"Barbar Darsono",
    //     "alamat":"Jalan Sesama, Surabaya",
    //     "reservasis":[{
    //          "tgl_berangkat":"2020-10-10",
    //          "destinasi":"Samosir"
    //        }]
    //    }}
    @PostMapping("/customer")
    public Customer newCustomer(@RequestBody BookingReq req) {
        return customerRepo.save(req.getCustomer());
    }

    @GetMapping("/customer/all")
    public List<BookingRes> getJoinInfo() {
        return customerRepo.getJoinInfo();
    }

    // GET QUERY PARAM
    // localhost:8080/customer?nama=Nama Customer
    @GetMapping("/customer")
    public List<BookingRes> getCustomer(String nama) {
        if (customerRepo.findByNama(nama).isEmpty()) {
            throw new DataNotFoundException(nama);
        }
        return customerRepo.findByNama(nama);
    }

    @PutMapping("/customer/{id}")
    public Customer editCustomer(@PathVariable Long id,
                                 @RequestBody Customer req) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new DataNotFoundException(id));
        customer.setNama(req.getNama());
        customer.setAlamat(req.getAlamat());

        return customerRepo.save(customer);
    }

    @DeleteMapping("/customer/{id)")
    public ResponseEntity<?> delCustomer(@PathVariable Long id) {
        return customerRepo.findById(id)
                .map(customer -> {
                    customerRepo.delete(customer);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new DataNotFoundException(id));
    }

}
