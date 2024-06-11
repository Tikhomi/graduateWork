package com.example.graduateWork.controller.common;

import com.example.graduateWork.dto.UsersDTO;
import com.example.graduateWork.entity.Client;
import com.example.graduateWork.entity.Users;
import com.example.graduateWork.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
    @GetMapping("/get/{idUser}")
    public ResponseEntity<?> getUserById(@PathVariable Long idUser) {
        Users user = usersService.findById(idUser);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllClients() {
        List<Users> users = usersService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}