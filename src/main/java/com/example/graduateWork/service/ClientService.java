package com.example.graduateWork.service;

import com.example.graduateWork.entity.Client;
import com.example.graduateWork.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client getClientById(Long idClient){
        return clientRepository.findById(idClient).orElse(null);
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public Long delete(Long idClient){
        clientRepository.deleteById(idClient);
        return idClient;
    }

}
