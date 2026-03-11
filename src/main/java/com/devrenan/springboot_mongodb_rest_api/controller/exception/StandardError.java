package com.devrenan.springboot_mongodb_rest_api.controller.exception;

import java.io.Serializable;

public class StandardError implements Serializable { // Classe padrão de erro
    private static final long serialVersionUID = 1L;

    private long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    private StandardError(){}

    public StandardError(long timestamp,  Integer status, String error, String message, String path) {
        this.error = error;
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
