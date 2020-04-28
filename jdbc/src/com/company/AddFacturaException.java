package com.company;

import java.sql.SQLException;

public class AddFacturaException extends Exception {

    public AddFacturaException(Throwable cause) {
        this.initCause(cause);
    }


    public String getMessage() {
        return "No se puede dar de alta la factura" + this.getCause();
    }
}
