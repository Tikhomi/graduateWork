package com.example.graduateWork.controller.common;

import com.example.graduateWork.entity.LoginRequest;
import com.example.graduateWork.entity.Users;
import com.example.graduateWork.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/login", method = { RequestMethod.GET, RequestMethod.POST })
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    private final UsersService usersService;

    public LoginController(UsersService usersService) {
        this.usersService = usersService;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred during login: " + e.getMessage());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody LoginRequest loginRequest) {
        Users user = usersService.authenticateUser(loginRequest);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("idUser", user.getIdUser());
        return ResponseEntity.ok(response);
    }
}
