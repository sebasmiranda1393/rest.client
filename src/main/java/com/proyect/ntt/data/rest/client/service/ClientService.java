package com.proyect.ntt.data.rest.client.service;

import org.springframework.stereotype.Service;
import com.proyect.ntt.data.rest.client.dto.Client;
import com.proyect.ntt.data.rest.client.exception.NoFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClientService {

    public Client gClient(String documentType, int documentNumber) {
        if (documentNumber == 23445322) {
            Client client = new Client(23445322, "Ben", "Andres", "Forero",
                    "Sossa", "3204599549", "610", "ibague de medellin alias nueva york");
            return client;
        } else {
            throw new NoFoundException("Usuario no encontrado");
        }

    }
}
