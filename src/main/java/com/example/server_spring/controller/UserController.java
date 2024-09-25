package com.example.server_spring.controller;

import com.example.server_spring.exception.UserAlreadyExistException;
import com.example.server_spring.model.User;
import com.example.server_spring.repo.UserRepo;
import com.example.server_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
     private UserService userService;
    @PostMapping
    public ResponseEntity registration(@RequestBody User user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранен!");
        }
        catch (UserAlreadyExistException error){
            return ResponseEntity.badRequest().body(error.getMessage());
        } catch (Exception error){
            return ResponseEntity.badRequest().body("Произошла ошбибка!");
        }
    }

    @GetMapping
    public ResponseEntity<String> geOneUser(@RequestParam Long id){
        try {
            userService.getOne(id);
            return ResponseEntity.ok("Сервер работает!");
        } catch (Exception error){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
