package com.divya.realestateapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divya.realestateapp.entities.Project;
import com.divya.realestateapp.repositories.ProjectRepository;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")   // frontend se call allow
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    // Landing page ke liye – saare projects
    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Admin panel – naya project add
    @PostMapping("/admin")
    public Project addProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }
}
