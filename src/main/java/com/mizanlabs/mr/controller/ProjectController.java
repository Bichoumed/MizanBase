package com.mizanlabs.mr.controller;
import com.mizanlabs.mr.entities.Project;
import com.mizanlabs.mr.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Project")
public class ProjectController {
    private final ProjectService ProjectService ;
    @Autowired
    public ProjectController(ProjectService ProjectService) {
        this.ProjectService = ProjectService;
    }
    
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project Project) {
    	Project savedProject = ProjectService.createProject(Project);
        return ResponseEntity.ok(savedProject);
    }
    
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
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project Project) {
        return ProjectService.updateProject(id, Project)
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


