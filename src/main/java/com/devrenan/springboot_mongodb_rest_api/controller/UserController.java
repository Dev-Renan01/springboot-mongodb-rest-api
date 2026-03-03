package com.devrenan.springboot_mongodb_rest_api.controller;

import Service.UserService;
import com.devrenan.springboot_mongodb_rest_api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String hello(){
      return "Olá, seja bem vindo(a)";
    }


    @PostMapping(value = "/save")
    public ResponseEntity<String> save(@RequestBody User user){
        userService.save(user);
        return ResponseEntity.ok().body("Usuário criado com sucesso!");
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<User>> findAll(){
        List<User> user = userService.findAll();
        return ResponseEntity.ok().body(user);

    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody User user){
        user.setId(id); //OBS: Pega o id da URL e coloca dentro do objeto!
        userService.update(user);
        return ResponseEntity.ok().body("Usuário atualizado com sucesso!");
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        userService.deleteById(id);
        return ResponseEntity.ok().body("Usuário deletado com sucesso!");
    }

}