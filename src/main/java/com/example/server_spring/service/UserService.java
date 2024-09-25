package com.example.server_spring.service;


import com.example.server_spring.exception.UserAlreadyExistException;
import com.example.server_spring.exception.UserNotFoundException;
import com.example.server_spring.model.User;
import com.example.server_spring.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User registration(User user) throws UserAlreadyExistException {
        if(userRepo.findByName(user.getUserName()) != null){
           throw new UserAlreadyExistException("Пользователь с таким именем существует! ");
        }
      User savedUser = userRepo.save(user);
        return savedUser;
    };

    public User getOne(Long id){
        User user = userRepo.findById(id).get();
        if(user == null) {
            throw new UserNotFoundException("Пользователь не найден!");
        };

        return user;
    };

}
