package com.divya.realestateapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divya.realestateapp.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
