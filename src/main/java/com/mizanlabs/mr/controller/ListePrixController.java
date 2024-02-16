package com.mizanlabs.mr.controller;

import com.mizanlabs.mr.entities.ListeDePrix;
import com.mizanlabs.mr.service.ListeDePrixService; // Ensure this matches the actual service class name
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ListeDePrixs") // This should match the Angular service's apiUrl
public class ListePrixController {

    private final ListeDePrixService listeDePrixService;

    @Autowired
    public ListePrixController(ListeDePrixService listeDePrixService) {
        this.listeDePrixService = listeDePrixService;
    }

    @PostMapping
    public ResponseEntity<ListeDePrix> createListeDePrix(@RequestBody ListeDePrix listeDePrix) {
        ListeDePrix savedListeDePrix = listeDePrixService.createListeDePrix(listeDePrix);
        return ResponseEntity.ok(savedListeDePrix);
    }

    @GetMapping
    public List<ListeDePrix> getAllListeDePrixs() {
        return listeDePrixService.getAllListeDePrixs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListeDePrix> getListeDePrixById(@PathVariable Long id) {
        return listeDePrixService.getListePrixById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListeDePrix> updateListeDePrix(@PathVariable Long id, @RequestBody ListeDePrix listeDePrix) {
        return listeDePrixService.updateListeDePrix(id, listeDePrix)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListeDePrix(@PathVariable Long id) {
        if (listeDePrixService.deleteListeDePrix(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
