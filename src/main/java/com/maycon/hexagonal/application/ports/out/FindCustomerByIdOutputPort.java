package com.maycon.hexagonal.application.ports.out;

import java.util.Optional;

import com.maycon.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);
}
