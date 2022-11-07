package com.cursor.cursorRestHW.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ShopNotFoundException extends RuntimeException {

    public ShopNotFoundException() {
        super();
    }
}
