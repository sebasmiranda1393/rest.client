package com.proyect.ntt.data.rest.client.util;

public enum ErrorEnum {

    NO_FOUND("Client not found"),
    BAD_REQUEST("Inconsistent data: %s [ %s ] is not allow");

    private String value;

    public String getMessage() {
        return this.value;
    }

    private ErrorEnum(String value) {
        this.value = value;
    }
}
