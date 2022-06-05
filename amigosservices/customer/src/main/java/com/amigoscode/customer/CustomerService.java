package com.amigoscode.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public void registerCustomer(CustomerRegistrationRequest request) {
        // use builder pattern
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        // todo: check if fraudster (request to fraud service)
        customerRepository.save(customer);
        // todo: send notification
    }
}
