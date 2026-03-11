package com.devrenan.springboot_mongodb_rest_api.service.exception;

public class ObjectNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;


    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
