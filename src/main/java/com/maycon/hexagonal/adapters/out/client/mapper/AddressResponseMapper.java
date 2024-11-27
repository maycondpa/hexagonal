package com.maycon.hexagonal.adapters.out.client.mapper;

import com.maycon.hexagonal.adapters.out.client.response.AddressResponse;
import com.maycon.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
