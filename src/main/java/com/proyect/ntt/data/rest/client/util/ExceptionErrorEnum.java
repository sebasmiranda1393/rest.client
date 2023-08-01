package com.proyect.ntt.data.rest.client.util;

public enum ExceptionErrorEnum {

    NO_FOUND("Client not found"),
    BAD_REQUEST("Inconsistent data: %s [ %s ] is not allow");

    private String value;

    public String getMessage() {
        return this.value;
    }

    private ExceptionErrorEnum(String value) {
        this.value = value;
    }

}
