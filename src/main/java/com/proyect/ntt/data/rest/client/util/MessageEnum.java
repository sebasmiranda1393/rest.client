package com.proyect.ntt.data.rest.client.util;

public enum MessageEnum {

    GET_CLIENT_MESSAGE("Obtener datos del usuario con tipo %s  y numero de documento %s"),
    INVALID_DOCUMENT_TYPE_ERROR("Document Type [ %s ] is no allow"),
    NO_FOUND_CLIENT_ERROR("The client with document number [ %s ] doesn't exist"),
    CLIENT_FOUND("The client with document type [ %s ] and document number [ %s ] was found with success");

    private String value;

    public String getValue() {
        return this.value;
    }

    private MessageEnum(String value) {
        this.value = value;
    }
}
