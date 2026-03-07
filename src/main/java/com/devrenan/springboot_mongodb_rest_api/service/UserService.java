package com.devrenan.springboot_mongodb_rest_api.service;
import com.devrenan.springboot_mongodb_rest_api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devrenan.springboot_mongodb_rest_api.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public Optional<User> findById(String id){
        if(id == null){
            throw new RuntimeException("Informe um id válido!");
        }

        if(!userRepository.existsById(id)){
            throw new RuntimeException("Usuário não encontrado!");
        }

       return userRepository.findById(id);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User update(User user){
        if(user.getId() == null){
            throw new RuntimeException("Informe um id válido!");
        }

        if(!userRepository.existsById(user.getId())){
            throw new RuntimeException("Usuário não encontrado!");
        }

        return userRepository.save(user);
    }

    public void deleteById(String id){
        if (id == null){
            throw new RuntimeException("Informe um id válido");
        }

        if(!userRepository.existsById(id)){
            throw new RuntimeException("Usuário não encontrado!");
        }
        userRepository.deleteById(id);
    }
}