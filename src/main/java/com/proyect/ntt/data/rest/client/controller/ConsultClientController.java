package com.proyect.ntt.data.rest.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.ntt.data.rest.client.dto.Client;
import com.proyect.ntt.data.rest.client.service.ClientService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ConsultClientController {

    private final ClientService clientService;

    @GetMapping("/{documentType}/{documentNumber}")
    public Client getClient(@PathVariable(name = "documentType") String documentType,
            @PathVariable(name = "documentNumber") int documentNumber) {
        return clientService.gClient(documentType,documentNumber);
    }

}
