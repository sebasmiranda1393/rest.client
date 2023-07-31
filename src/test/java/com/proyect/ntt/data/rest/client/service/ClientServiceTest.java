package com.proyect.ntt.data.rest.client.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.proyect.ntt.data.rest.client.exception.BadRequestException;
import org.junit.jupiter.api.Test;

class ClientServiceTest {

    ClientService clientService = new ClientService();

    @Test
    public void test_WhenDocumentTypeIsInvalidThenShouldThrowBadRequestException(){

        BadRequestException exception = assertThrows(BadRequestException.class, () ->
                clientService.gClient("A", 23445322));
        assertTrue(exception.getMessage().equals("Inconsistent data: Document type [ A ] is not allow"));
    }

}