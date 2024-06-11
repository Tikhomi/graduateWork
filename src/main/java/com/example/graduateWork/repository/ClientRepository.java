package com.example.graduateWork.repository;

import com.example.graduateWork.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long> {
    Client getClientByIdClient (Long idClient);

}
