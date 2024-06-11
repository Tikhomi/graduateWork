package com.example.graduateWork.repository;

import com.example.graduateWork.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long> {
    Client getClientByIdClient (Long idClient);
    Optional<Client> findByUsersIdUser(Long idUser);

}
