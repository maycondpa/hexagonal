package com.maycon.hexagonal.config;

import com.maycon.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.maycon.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.maycon.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.maycon.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                       FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                       UpdateCustomerAdapter updateCustomerAdapter) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
