package com.mizanlabs.mr.repository;


import com.mizanlabs.mr.entities.ListeDePrix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListeDePrixRepository extends JpaRepository<ListeDePrix, Long> {
    // Ajoutez des méthodes spécifiques si nécessaire
	
}
