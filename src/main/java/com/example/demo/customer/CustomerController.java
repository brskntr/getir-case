package com.example.demo.customer;

import com.example.demo.order.OrderResource;
import com.example.demo.security.JwtTokenUtil;
import com.example.demo.shared.model.CaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author bariskantar
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final JwtTokenUtil jwtTokenUtil;

    public CustomerController(CustomerService customerService, JwtTokenUtil jwtTokenUtil) {
        this.customerService = customerService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/create")
    public CaseResponse<CustomerResource> create(@RequestBody CustomerDto customerDto){
        return new CaseResponse<>(customerService.create(customerDto));
    }

    @GetMapping("/orders")
    public CaseResponse<List<OrderResource>> orders(@RequestHeader("X-Auth")String authHeader){
        String customerId = jwtTokenUtil.getUsernameFromToken(authHeader);
        return new CaseResponse<>(customerService.getOrders(customerId));
    }
}
