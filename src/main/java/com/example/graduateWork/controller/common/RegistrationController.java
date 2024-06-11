package com.example.graduateWork.controller.common;

import com.example.graduateWork.entity.RegistrationRequest;
import com.example.graduateWork.entity.Users;
import com.example.graduateWork.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value ="/api/register", method = { RequestMethod.GET, RequestMethod.POST })
@CrossOrigin(origins = "http://localhost:3000")
public class RegistrationController {

    private final UsersService userService;

    public RegistrationController(UsersService userService) {
        this.userService = userService;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred during registration: " + e.getMessage());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        Users newUser = userService.registerUser(registrationRequest);
        System.out.println("Newly registered user ID: " + newUser.getIdUser());
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Registration successful");
        response.put("idUser", newUser.getIdUser());
        return ResponseEntity.ok(response);
    }
}
