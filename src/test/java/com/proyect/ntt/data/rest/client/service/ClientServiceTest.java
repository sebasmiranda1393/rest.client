package com.proyect.ntt.data.rest.client.service;

import com.proyect.ntt.data.rest.client.dto.Client;
import com.proyect.ntt.data.rest.client.exception.BadRequestException;
import com.proyect.ntt.data.rest.client.exception.CharacterInvalidateException;
import com.proyect.ntt.data.rest.client.exception.NoFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceTest {

    ClientService clientService = new ClientService();

    @ParameterizedTest
    @MethodSource("exception_parameters")
    public void test_processValues_throwException(String documentType, String documentNumber, Class ex) {
        Exception exception = (Exception) assertThrows(ex, () ->
                clientService.getClient(documentType, documentNumber));
        assertTrue(exception.getClass().equals(ex));
    }

    private static Stream<Arguments> exception_parameters() {
        return Stream.of(
                Arguments.of("A", "23445322", BadRequestException.class),
                Arguments.of("A*", "23445322", CharacterInvalidateException.class),
                Arguments.of("P", "234453224", NoFoundException.class)
        );
    }

    @ParameterizedTest
    @MethodSource("Ok_parameters")
    public void test_processValuesOk(String documentType, String documentNumber) {

        Client client = clientService.getClient(documentType, documentNumber);
        assertNotNull(client);
        assertEquals(client.getFirstName(), "Sebastian");
    }

    private static Stream<Arguments> Ok_parameters() {
        return Stream.of(
                Arguments.of("C", "23445322"),
                Arguments.of("P", "23445322")
        );
    }

}