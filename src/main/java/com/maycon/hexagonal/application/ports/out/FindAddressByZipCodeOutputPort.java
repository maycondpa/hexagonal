package com.maycon.hexagonal.application.ports.out;

import com.maycon.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
