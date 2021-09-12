package com.example.demo.book;

import com.example.demo.shared.model.CaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bariskantar
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @PostMapping("/create")
    public CaseResponse<BookResource> create(@RequestBody BookDto bookDto) {
        return new CaseResponse(bookService.create(bookDto));
    }

    @PutMapping("/update-stock")
    public CaseResponse<BookResource> updateStock(@RequestBody UpdateStockDto updateStockDto) {
        return new CaseResponse(bookService.updateStock(updateStockDto));
    }
}
