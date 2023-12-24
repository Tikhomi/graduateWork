package com.example.graduateWork.service;

import com.example.graduateWork.dto.UsersDTO;
import com.example.graduateWork.entity.RegistrationRequest;
import com.example.graduateWork.entity.Role;
import com.example.graduateWork.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.graduateWork.repository.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UsersDTO> getAllUserInfos() {
        List<Users> users = usersRepository.findAll();
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UsersDTO findByPhoneNumber(int phoneNumber) {
        Users users = usersRepository.findByPhoneNumber(phoneNumber);
        if (users != null) {
            return convertToDTO(users);
        }
        return null;
    }

    public Users save(Users users) {
        return usersRepository.save(users);
    }

    public Long delete(Long id_user) {
        usersRepository.deleteById(id_user);
        return id_user;
    }

    private UsersDTO convertToDTO(Users users) {
        return new UsersDTO(users.getId_user(), users.getPhoneNumber());

    }

    public void registerUser(RegistrationRequest registrationRequest) {
        Users newUser = new Users();
        newUser.setPhoneNumber(registrationRequest.getPhoneNumber());
        newUser.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        newUser.setRole(Role.valueOf(registrationRequest.getRole()));

        usersRepository.save(newUser);
    }

}

