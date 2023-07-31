package com.proyect.ntt.data.rest.client.service;

import com.proyect.ntt.data.rest.client.exception.BadRequestException;
import com.proyect.ntt.data.rest.client.util.DocumentType;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.proyect.ntt.data.rest.client.dto.Client;
import com.proyect.ntt.data.rest.client.exception.NoFoundException;

import com.proyect.ntt.data.rest.client.util.ErrorEnum;

import java.util.Arrays;
import java.util.List;
import static java.lang.String.format;

@NoArgsConstructor
@Service
@Slf4j
public class ClientService {

    public Client getClient(String documentType, int documentNumber) {
        validate(documentType,documentNumber);
        Client client = new Client(23445322, "Ben", "Andres", "Forero",
                "Sossa", "3204599549", "610", "ibague de medellin alias nueva york");
        return client;
    }

    private void validate(String documentType, int documentNumber) {
        validateDocumentType(documentType);
        validateExistClient(documentNumber);
    }

    private void validateDocumentType(String documentType) {
        List<String> documentTypes = Arrays.asList(DocumentType.CEDULA.getValue(), DocumentType.PASAPORTE.getValue());
        if (!documentTypes.contains(documentType)) {
            log.error(format("Document Type [ %s ] is no allow",documentType));
            throw new BadRequestException((format(ErrorEnum.BAD_REQUEST.getMessage(), "Document type", documentType)));
        }
    }

    private void validateExistClient(int documentNumber) {
        if (documentNumber != 23445322) {
            throw new NoFoundException(ErrorEnum.NO_FOUND.getMessage());
        }
    }
}
