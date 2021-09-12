package com.example.demo.shared.model;

import lombok.AllArgsConstructor;
import lombok.Data;
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
@AllArgsConstructor
public class CaseResponse<T> implements Serializable {
    private String message;
    private T data;

    public CaseResponse(T data){
        this.data = data;
    }
}
