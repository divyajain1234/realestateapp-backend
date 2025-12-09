package com.divya.realestateapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divya.realestateapp.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
