package com.example.demo.customer;

import com.example.demo.exceptions.DuplicateException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.order.OrderResource;
import com.example.demo.security.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bariskantar
 */
@Slf4j
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final JwtTokenUtil jwtTokenUtil;


    public CustomerService(CustomerRepository customerRepository, ModelMapper modelMapper, JwtTokenUtil jwtTokenUtil) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public CustomerResource create(CustomerDto customerDto){
        log.info("[CustomerService.create] customerDto {}",customerDto);
        customerRepository.findByEmail(customerDto.getEmail()).ifPresent(c->{
            throw new DuplicateException("The provided email not available on system.");
        });
        CustomerEntity customerEntity = modelMapper.map(customerDto, CustomerEntity.class);
        customerRepository.save(customerEntity);
        CustomerResource customerResource = modelMapper.map(customerEntity, CustomerResource.class);
        customerResource.setToken(jwtTokenUtil.generateToken(customerEntity.getId()));
        return customerResource;
    }

    public List<OrderResource> getOrders(String customerId) {
        CustomerEntity customerEntity = customerRepository.findById(customerId).orElseThrow(() -> new NotFoundException("Customer not found"));
        return modelMapper.map(customerEntity.getOrders(),new TypeToken<List<OrderResource>>() {}.getType());
    }
}
