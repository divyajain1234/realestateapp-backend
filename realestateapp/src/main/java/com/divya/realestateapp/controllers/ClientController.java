package com.divya.realestateapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divya.realestateapp.entities.Client;
import com.divya.realestateapp.repositories.ClientRepository;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    // Landing page ke liye – saare clients (Happy Clients section)
    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Admin panel – naya client add
    @PostMapping("/admin")
    public Client addClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }
}
