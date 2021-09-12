package com.example.demo.order;

import com.example.demo.book.BookResource;
import com.example.demo.customer.CustomerResource;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * @author bariskantar
 */
@Getter
@Setter
public class OrderResource {
    private String id;
    private BookResource book;
    private CustomerResource customer;
    private int count;
    private BigDecimal totalAmount;
    private ZonedDateTime createDate;
}
