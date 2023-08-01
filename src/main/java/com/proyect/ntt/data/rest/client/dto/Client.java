package com.proyect.ntt.data.rest.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class Client {

    private String id;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private String phone;
    private String address;
    private String city;
}
