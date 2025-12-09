package com.divya.realestateapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divya.realestateapp.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
