package com.proyect.ntt.data.rest.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class Client {

    private int id;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondtLastName;
    private String phone;
    private String address;
    private String city;
}
