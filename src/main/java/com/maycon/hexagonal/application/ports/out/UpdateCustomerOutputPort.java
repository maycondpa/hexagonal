package com.maycon.hexagonal.application.ports.out;

import com.maycon.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
