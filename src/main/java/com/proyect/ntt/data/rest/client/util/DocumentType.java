package com.proyect.ntt.data.rest.client.util;

public enum DocumentType {

    CEDULA("CC"),
    PASAPORTE("P");

    private String value;

    public String getValue() {
        return this.value;
    }

    private DocumentType(String value) {
        this.value = value;
    }
}
