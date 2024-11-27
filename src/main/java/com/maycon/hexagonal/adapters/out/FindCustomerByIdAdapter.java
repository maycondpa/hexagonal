package com.maycon.hexagonal.adapters.out;

import java.util.Optional;

import com.maycon.hexagonal.adapters.out.repository.CustomerRepository;
import com.maycon.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.maycon.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.maycon.hexagonal.application.core.domain.Customer;
import com.maycon.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
