package com.example.demo.book;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author bariskantar
 */
@Getter
@Setter
public class BookDto implements Serializable {

    private String author;

    private String name;

    private int stockCount;

    private BigDecimal price;
}
