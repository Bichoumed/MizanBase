package com.mizanlabs.mr.controller;
import com.mizanlabs.mr.entities.Project;
import com.mizanlabs.mr.service.ClientService;
import com.mizanlabs.mr.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Project")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

public class ProjectController {
    private final ProjectService ProjectService ;
    @Autowired
    private ClientService clientService;
    @Autowired
    public ProjectController(ProjectService ProjectService) {
        this.ProjectService = ProjectService;
    }
    @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project, @RequestParam Long clientId) {
        if (clientId != null) {
            clientService.getClientById(clientId).ifPresent(project::setClient);
        }
        Project savedProject = ProjectService.createProject(project);
        return ResponseEntity.ok(savedProject);
    }
    @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project projectDetails) {
        return ProjectService.getProjectById(id).map(existingProject -> {
            if (projectDetails.getClient() != null && projectDetails.getClient().getId() != null) {
                clientService.getClientById(projectDetails.getClient().getId()).ifPresent(existingProject::setClient);
            }
            // Update other fields of existingProject as needed
            existingProject.setName(projectDetails.getName());
            // ... other fields update

            Project updatedProject = ProjectService.save(existingProject); // Assuming save method exists in your service
            return ResponseEntity.ok(updatedProject);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")


    @GetMapping
    public List<Project> getAllProject() {
        return ProjectService.getAllProject();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        return ProjectService.getProjectById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        if (ProjectService.deleteClient(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


