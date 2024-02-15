package com.mizanlabs.mr.service;

import com.mizanlabs.mr.entities.Project;
import com.mizanlabs.mr.repository.ProjectRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {




    private final ProjectRepository ProjectRepository;

    @Autowired
    public ProjectService(ProjectRepository ProjectRepository) {
        this.ProjectRepository = ProjectRepository;
    }

    public List<Project> getAllProject() {
        return ProjectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        return ProjectRepository.findById(id);
    }

   public  Project createProject(Project Project) {
        return ProjectRepository.save(Project);
    }
    public Optional<Project> updateProject(Long id, Project ProjectDetails) {
        return ProjectRepository.findById(id).map(Project -> {
        	Project.setCreationDate(ProjectDetails.getCreationDate());
        	Project.setProjectLocation(ProjectDetails.getProjectLocation());
        	Project.setProjectBCT(ProjectDetails.getProjectBCT());
        	Project.setProjectMOE(ProjectDetails.getProjectMOE());
        	Project.setProjectMO(ProjectDetails.getProjectMO());
        	Project.setProjectMO(ProjectDetails.getProjectMO());
        	Project.setName(ProjectDetails.getName());

            return ProjectRepository.save(Project);
        });
    }
    
    public boolean deleteClient(Long id) {
        boolean exists = ProjectRepository.existsById(id);
        if (!exists) {
            return false;
        }
        ProjectRepository.deleteById(id);
        return true;
    }


}
