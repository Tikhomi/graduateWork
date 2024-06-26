package com.example.graduateWork.controller.common;

import com.example.graduateWork.entity.Client;
import com.example.graduateWork.entity.Users;
import com.example.graduateWork.service.ClientService;
import com.example.graduateWork.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/client", method = { RequestMethod.GET, RequestMethod.POST })
@CrossOrigin(origins = "http://localhost:3000/ClientF")
public class ClientController {
    private final ClientService clientService;
    private final UsersService usersService;

    @Autowired
    public ClientController(ClientService clientService, UsersService usersService) {
        this.clientService = clientService;
        this.usersService = usersService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/get/{idClient}")
    public ResponseEntity<Client> getClientById(@PathVariable("idClient") Long idClient) {
        Client client = clientService.getClientById(idClient);
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getByUserId/{idUser}")
    public ResponseEntity<Client> getClientByUserId(@PathVariable("idUser") Long idUser) {
        Client client = clientService.getClientByUserId(idUser);
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public void addClient(@RequestBody Client client) {
        clientService.save(client);
    }

    @DeleteMapping("/del/{idClient}")
    public ResponseEntity<Void> deleteClient(@PathVariable("idClient") Long idClient) {
        clientService.delete(idClient);
        return ResponseEntity.noContent().build();
    }
}
