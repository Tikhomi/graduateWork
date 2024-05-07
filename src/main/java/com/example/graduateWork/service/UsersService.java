package com.example.graduateWork.service;

import com.example.graduateWork.dto.UsersDTO;
import com.example.graduateWork.entity.registration.RegistrationRequest;
import com.example.graduateWork.entity.Role;
import com.example.graduateWork.entity.Users;
import com.example.graduateWork.repository.UsersRepository;
import com.example.graduateWork.service.sms.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final SmsService smsService;

    @Autowired
    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder, SmsService smsService) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.smsService = smsService;
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

        //проверка пароля на его отсутствие
        if (registrationRequest.getPassword() == null || registrationRequest.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        //проверка номера телефона на его отсутствие
        if (registrationRequest.getPhoneNumber() == null) {
            throw new IllegalArgumentException("Phone number cannot be null");
        }

        //проверка номера телефона на то чтобы он начинался с 7 и был ровно 11 символов
        if (registrationRequest.getPhoneNumber() < 70000000000L || registrationRequest.getPhoneNumber() >= 80000000000L) {
            throw new IllegalArgumentException("Phone number must start with 7");
        }

        Users newUser = new Users();

        newUser.setPhoneNumber(registrationRequest.getPhoneNumber());

        System.out.println("Введенный номер телефона: " + registrationRequest.getPhoneNumber());
        newUser.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        System.out.println("Введенный пароль: " + registrationRequest.getPassword());
        newUser.setRole(Role.ROLE_PATIENT);
        System.out.println("сейчас будет сохранение");
        usersRepository.save(newUser);
        System.out.println("сразу после сохранения");
        //smsService.sendSms(registrationRequest.getPhoneNumber());
    }
}
