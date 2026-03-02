package com.devrenan.springboot_mongodb_rest_api.controller;

import com.devrenan.springboot_mongodb_rest_api.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public String hello(){
      return "Olá, seja bem vindo(a)";
    }

    @GetMapping(value = "/listar")
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "Maria de Souza", "maria@gmail.com");
        User joao = new User("2", "joão Renan", "joao@gmail.com");

        List<User> users = new ArrayList<>();
        users.add(maria);  //Add os Users na lista, poderia ser tambem - users.addAll(Array.asList(joao, maria))
        users.add(joao);
        return ResponseEntity.ok().body(users);


    }
}