package com.example.demo.book;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author bariskantar
 */
@Getter
@Setter
public class BookResource {
    private String id;
    private String author;
    private String name;
    private String stockCount;
    private BigDecimal price;
}
