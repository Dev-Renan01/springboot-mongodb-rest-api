package com.devrenan.springboot_mongodb_rest_api.controller;

import com.devrenan.springboot_mongodb_rest_api.dto.UserResponseDTO;
import com.devrenan.springboot_mongodb_rest_api.service.UserService;
import com.devrenan.springboot_mongodb_rest_api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<UserResponseDTO> save(@RequestBody User user) {

       User user1 = service.save(user);
        return ResponseEntity.ok().body(new UserResponseDTO(user1));
    }


    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable String id){

        Optional<User> users = service.findById(id);

        return ResponseEntity.ok().body(new UserResponseDTO(users.get()));
    }


    @GetMapping(value = "/findAll")
     public ResponseEntity<List<UserResponseDTO>> findAll(){

        List<User> users = service.findAll();
        List<UserResponseDTO> usersDTO = new ArrayList<>();

        for(User user : users){
            usersDTO.add(new UserResponseDTO(user));
        }
        return ResponseEntity.ok().body(usersDTO);
      }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable String id, @RequestBody User user){

        user.setId(id); //OBS: Pega o id da URL e coloca dentro do objeto!
        User user1 = service.update(user);

        return ResponseEntity.ok().body(new UserResponseDTO(user1));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        service.deleteById(id);
        return ResponseEntity.ok().body("Usuário deletado com sucesso!");
    }

}