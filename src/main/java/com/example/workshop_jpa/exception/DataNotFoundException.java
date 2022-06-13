package com.example.workshop_jpa.exception;

import java.util.function.Supplier;

public class DataNotFoundException extends RuntimeException  {

    public DataNotFoundException(String message){
        super(message);
    }


}
