package com.agen.pariwisata.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtil {
    public ModelMapper ModelMapperInit(){
        return new ModelMapper();
    }
}
