package com.example.demo.order;

import com.example.demo.book.BookEntity;
import com.example.demo.book.BookRepository;
import com.example.demo.customer.CustomerEntity;
import com.example.demo.customer.CustomerRepository;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * @author bariskantar
 */
@Slf4j
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;
    private final BookRepository bookRepository;

    public OrderService(OrderRepository orderRepository, ModelMapper modelMapper, CustomerRepository customerRepository, BookRepository bookRepository) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
        this.bookRepository = bookRepository;
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }

    public OrderResource create(OrderDto orderDto){
        log.info("Order -> {}",orderDto);
        
        if(orderDto.getCount()<=0){
            throw new BadRequestException("Item count must greater than 0");
        }

        BookEntity bookEntity = bookRepository.findById(orderDto.getBookId()).orElseThrow(() -> new NotFoundException("Book not found"));
        if(bookEntity.getStockCount()<orderDto.getCount()){
            throw new BadRequestException("Stock count of book is less than requested.");
        }

        bookEntity.setStockCount(bookEntity.getStockCount()-orderDto.getCount());
        bookRepository.save(bookEntity);

        CustomerEntity customerEntity = customerRepository.findById(orderDto.getCustomerId()).orElseThrow(() -> new NotFoundException("Customer not found"));
        OrderEntity orderEntity = modelMapper.map(orderDto, OrderEntity.class);
        orderEntity.setCustomer(customerEntity);
        orderEntity.setBook(bookEntity);
        orderEntity.setTotalAmount(BigDecimal.valueOf(orderDto.getCount()).multiply(bookEntity.getPrice()));
        orderEntity.setStatus(OrderStatus.CREATED);
        orderRepository.save(orderEntity);
        return modelMapper.map(orderEntity, OrderResource.class);
    }

    public OrderResource get(String orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow(() -> new NotFoundException("Order not found"));
        return modelMapper.map(orderEntity, OrderResource.class);
    }

    public List<OrderResource> listByDateRange(ZonedDateTime startDate, ZonedDateTime endDate) {
        List<OrderEntity> orderEntityList = orderRepository.findByCreateDateBetween(startDate, endDate);
        return modelMapper.map(orderEntityList,new TypeToken<List<OrderResource>>() {}.getType());
    }
}
