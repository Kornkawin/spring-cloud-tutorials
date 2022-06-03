package com.amigoscode.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    /*
        Model component in MVC design pattern
        for responding to Controller component
    */
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
