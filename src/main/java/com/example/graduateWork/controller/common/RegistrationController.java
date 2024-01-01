package com.example.graduateWork.controller.common;

import com.example.graduateWork.entity.RegistrationRequest;
import com.example.graduateWork.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/api/register", method = { RequestMethod.GET, RequestMethod.POST })
@CrossOrigin(origins = "http://localhost:3000")
public class RegistrationController {

    private final UsersService userService;

    public RegistrationController(UsersService usersService) {
        this.userService = usersService;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred during registration: " + e.getMessage());
    }

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        userService.registerUser(registrationRequest);

        return ResponseEntity.ok("Registration successful");
    }
}
