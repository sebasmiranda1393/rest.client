package com.proyect.ntt.data.rest.client.service;

import com.proyect.ntt.data.rest.client.exception.BadRequestException;
import com.proyect.ntt.data.rest.client.util.DocumentType;
import com.proyect.ntt.data.rest.client.util.Utility;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.proyect.ntt.data.rest.client.dto.Client;
import com.proyect.ntt.data.rest.client.exception.NoFoundException;
import com.proyect.ntt.data.rest.client.util.ExceptionErrorEnum;

import java.util.Arrays;
import java.util.List;

import static com.proyect.ntt.data.rest.client.util.MessageEnum.CLIENT_FOUND;
import static com.proyect.ntt.data.rest.client.util.MessageEnum.NO_FOUND_CLIENT_ERROR;
import static com.proyect.ntt.data.rest.client.util.MessageEnum.INVALID_DOCUMENT_TYPE_ERROR;
import static com.proyect.ntt.data.rest.client.util.MessageEnum.GET_CLIENT_MESSAGE;

import static java.lang.String.format;

@NoArgsConstructor
@Service
@Slf4j
public class ClientService {

    public Client getClient(String documentType, String documentNumber) {
        log.info(format(GET_CLIENT_MESSAGE.getValue(), documentType, documentNumber));
        validate(documentType, documentNumber);
        return buildClient(documentType, documentNumber);
    }

    private void validate(String documentType, String documentNumber) {
        Utility utility = new Utility();
        utility.characterValidate(documentType);
        utility.characterValidate(String.valueOf(documentNumber));
        validateDocumentType(documentType);
        validateExistClient(documentNumber);
    }

    private void validateDocumentType(String documentType) {
        List<String> documentTypes = Arrays.asList(DocumentType.CEDULA.getValue(), DocumentType.PASAPORTE.getValue());
        if (!documentTypes.contains(documentType)) {
            log.error(format(INVALID_DOCUMENT_TYPE_ERROR.getValue(), documentType));
            throw new BadRequestException((format(ExceptionErrorEnum.BAD_REQUEST.getMessage(), "Document type", documentType)));
        }
    }

    private void validateExistClient(String documentNumber) {
        if (!documentNumber.equals("23445322")) {
            log.error(format(NO_FOUND_CLIENT_ERROR.getValue(), documentNumber));
            throw new NoFoundException(ExceptionErrorEnum.NO_FOUND.getMessage());
        }
    }

    private Client buildClient(String documentType, String documentNumber) {
        log.info(format(CLIENT_FOUND.getValue(), documentType, documentNumber));
        return Client.builder()
                .firstName("Sebastian")
                .secondName("Arnulfo")
                .firstLastName("Hernandez")
                .secondLastName("Miranda")
                .phone("3144452921")
                .address("torre 3 apt610")
                .city("Ibagué")
                .build();
    }
}
