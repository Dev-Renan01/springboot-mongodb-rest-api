package com.devrenan.springboot_mongodb_rest_api.controller;

import com.devrenan.springboot_mongodb_rest_api.dto.UserDTO;
import com.devrenan.springboot_mongodb_rest_api.service.UserService;
import com.devrenan.springboot_mongodb_rest_api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<String> save(@RequestBody User user) {
        service.save(user);
        return ResponseEntity.ok().body("Usuário criado com sucesso!");
    }

    @GetMapping(value = "/findById")
    public Optional<User> findById(@PathVariable String id){
        return service.findById(id);

    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> user = service.findAll();
        List<UserDTO> userDTO =  
        return ResponseEntity.ok().body(userDTO);

    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody User user){
        user.setId(id); //OBS: Pega o id da URL e coloca dentro do objeto!
        service.update(user);
        return ResponseEntity.ok().body("Usuário atualizado com sucesso!");
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        service.deleteById(id);
        return ResponseEntity.ok().body("Usuário deletado com sucesso!");
    }

}