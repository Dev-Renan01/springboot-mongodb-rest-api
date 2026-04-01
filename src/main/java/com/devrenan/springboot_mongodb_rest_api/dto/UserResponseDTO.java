package com.devrenan.springboot_mongodb_rest_api.dto;

import com.devrenan.springboot_mongodb_rest_api.model.User;

public class UserResponseDTO {

    private String id;
    private String name;
    private String email;

    public UserResponseDTO(){}

    public UserResponseDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}