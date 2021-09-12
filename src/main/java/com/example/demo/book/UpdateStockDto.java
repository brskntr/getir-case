package com.example.demo.book;

import lombok.Data;

/**
 * @author bariskantar
 */
@Data
public class UpdateStockDto {
    private String bookId;
    private int stockCount;
}
