package com.agen.pariwisata.exception;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(Long id){
        super("data dengan id: "+id+", tidak ada di database");
    }
    public DataNotFoundException(String nama){
        super("data "+nama+" tidak ada di database");
    }
}
