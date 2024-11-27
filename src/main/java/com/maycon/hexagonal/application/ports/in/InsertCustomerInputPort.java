package com.maycon.hexagonal.application.ports.in;

import com.maycon.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
