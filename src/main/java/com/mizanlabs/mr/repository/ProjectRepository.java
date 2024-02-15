package com.mizanlabs.mr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mizanlabs.mr.entities.Project;

@Repository

public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Additional methods, if necessary, can be defined here
}