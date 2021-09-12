package com.example.demo.customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author bariskantar
 */
@Getter
@Setter
@NoArgsConstructor
public class CustomerDto implements Serializable {

    private String email;
    private String fullName;
}
