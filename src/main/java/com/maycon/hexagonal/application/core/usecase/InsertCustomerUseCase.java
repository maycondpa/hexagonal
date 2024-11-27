package com.maycon.hexagonal.application.core.usecase;

import com.maycon.hexagonal.application.core.domain.Address;
import com.maycon.hexagonal.application.core.domain.Customer;
import com.maycon.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.maycon.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.maycon.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.maycon.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutPutPort;

    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutPutPort,
                                 SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutPutPort = insertCustomerOutPutPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode ) {
        Address address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutPutPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }
}
