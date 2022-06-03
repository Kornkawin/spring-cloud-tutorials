package com.amigoscode.fraud;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    private final FraudCheckService fraudCheckService;

    // constructor
    public FraudController(FraudCheckService fraudCheckService) {
        this.fraudCheckService = fraudCheckService;
    }

    // GET method with one request parameter
    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("customerId") Integer customerID
    ) {
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerID);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
