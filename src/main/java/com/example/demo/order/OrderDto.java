package com.example.demo.order;

import lombok.Getter;
import lombok.Setter;

/**
 * @author bariskantar
 */
@Getter
@Setter
public class OrderDto {
    private String customerId;
    private String bookId;
    private int count;

    @Override
    public String toString() {
        return "OrderDto{" +
                "customerId='" + customerId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", count=" + count +
                '}';
    }
}
