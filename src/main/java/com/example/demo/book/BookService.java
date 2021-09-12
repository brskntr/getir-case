package com.example.demo.book;

import com.example.demo.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * @author bariskantar
 */
@Slf4j
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;


    public BookService(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    public BookResource create(BookDto bookDto){
        log.info("[BookService.create] bookDto {}",bookDto);
        BookEntity bookEntity = modelMapper.map(bookDto, BookEntity.class);
        bookRepository.save(bookEntity);
        return modelMapper.map(bookEntity,BookResource.class);
    }

    public BookResource updateStock(UpdateStockDto updateStockDto){
        BookEntity bookEntity = bookRepository.findById(updateStockDto.getBookId()).orElseThrow(() -> new NotFoundException("Book not found"));
        bookEntity.setStockCount(updateStockDto.getStockCount());
        bookRepository.save(bookEntity);
        return modelMapper.map(bookEntity,BookResource.class);
    }
}
