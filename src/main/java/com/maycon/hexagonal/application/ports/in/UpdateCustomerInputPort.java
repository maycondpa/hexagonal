package com.maycon.hexagonal.application.ports.in;

import com.maycon.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);
}
