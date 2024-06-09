package com.example.graduateWork.repository;

import com.example.graduateWork.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByPhoneNumber(Long phoneNumber);

}