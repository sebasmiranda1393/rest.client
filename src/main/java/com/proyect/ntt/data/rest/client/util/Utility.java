package com.proyect.ntt.data.rest.client.util;

import com.proyect.ntt.data.rest.client.exception.CharacterInvalidateException;
import java.util.regex.Pattern;

public class Utility {

    public void characterValidate(String value){
        Pattern regex = Pattern.compile("[$&+,:;=\\\\?@#|/'<>.^*()%!-]");

        if (regex.matcher(value).find()) {
            throw new CharacterInvalidateException("Caracter especial no permitido");
        }
    }
}
