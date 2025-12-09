package com.divya.realestateapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divya.realestateapp.entities.Subscriber;
import com.divya.realestateapp.repositories.SubscriberRepository;

@RestController
@RequestMapping("/api/subscribers")
@CrossOrigin(origins = "*")
public class SubscriberController {

    @Autowired
    private SubscriberRepository subscriberRepository;

    // Newsletter section – subscribe email
    @PostMapping
    public Subscriber addSubscriber(@RequestBody Subscriber subscriber) {
        return subscriberRepository.save(subscriber);
    }

    // Admin panel – saare subscribed emails
    @GetMapping("/admin")
    public List<Subscriber> getAllSubscribers() {
        return subscriberRepository.findAll();
    }
}
