package com.maycon.hexagonal.application.ports.in;

import com.maycon.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
