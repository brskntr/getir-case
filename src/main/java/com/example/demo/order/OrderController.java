package com.example.demo.order;

import com.example.demo.security.JwtTokenUtil;
import com.example.demo.shared.model.CaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

/**
 * @author bariskantar
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private final JwtTokenUtil jwtTokenUtil;
    private final OrderService orderService;

    public OrderController(JwtTokenUtil jwtTokenUtil, OrderService orderService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.orderService = orderService;
    }

    @GetMapping("/get/{id}")
    public CaseResponse<OrderResource> create(@PathVariable("id")String orderId){
        return new CaseResponse<>(orderService.get(orderId));
    }

    @GetMapping("/get/date-range")
    public CaseResponse<OrderResource> create(@RequestParam("startDate") ZonedDateTime startDate,
                                              @RequestParam("endDate") ZonedDateTime endDate){
        return new CaseResponse<>();
    }

    @PostMapping("/create")
    public CaseResponse<OrderResource> create(@RequestHeader("X-Auth")String authHeader,
                                             @RequestBody OrderDto orderDto) {
        String customerId = jwtTokenUtil.getUsernameFromToken(authHeader);
        orderDto.setCustomerId(customerId);
        return new CaseResponse<>(orderService.create(orderDto));
    }
}
