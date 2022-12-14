package com.etiya.ecommercedemopair5.core.util.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    ModelMapper getMapper();
    ModelMapper forResponse();

    ModelMapper forRequest();
}
