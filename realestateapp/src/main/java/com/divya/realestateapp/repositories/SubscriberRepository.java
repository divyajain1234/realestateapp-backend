package com.divya.realestateapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divya.realestateapp.entities.Subscriber;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
}
