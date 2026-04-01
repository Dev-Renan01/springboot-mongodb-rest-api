package com.devrenan.springboot_mongodb_rest_api.controller;

import com.devrenan.springboot_mongodb_rest_api.dto.UserRequestDTO;
import com.devrenan.springboot_mongodb_rest_api.dto.UserResponseDTO;
import com.devrenan.springboot_mongodb_rest_api.service.UserService;
import com.devrenan.springboot_mongodb_rest_api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public String hello(){
      return "Olá, seja bem vindo(a)";
    }


    @PostMapping(value = "/save")
    public ResponseEntity<UserResponseDTO> save(@RequestBody UserRequestDTO dto) {
        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        User userSalvo = service.save(user);

        return ResponseEntity.ok().body(new UserResponseDTO(userSalvo));
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable String id){
        Optional<User> users = service.findById(id);

        return ResponseEntity.ok(new UserResponseDTO(users.get()));
    }

    @GetMapping(value = "/findAll")
     public ResponseEntity<List<UserResponseDTO>> findAll() {
        List<User> users = new ArrayList<>();

        List<UserResponseDTO> lista = new ArrayList<>();

        for(User u : users) {
            lista.add(new UserResponseDTO(u));
        }
        return ResponseEntity.status(HttpStatus.OK).body(lista);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable String id, @RequestBody UserRequestDTO dto){
        User user = new User();
        user.setId(id);

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        return ResponseEntity.ok(new UserResponseDTO(user));

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.deleteById(id);

        return ResponseEntity.noContent().build();

    }
}