package com.proyect.ntt.data.rest.client.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class Error {

    private String exceptionName;
    private String message;

}
