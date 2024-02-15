package com.mizanlabs.mr.controller;

import com.mizanlabs.mr.entities.ListeDePrix;
import com.mizanlabs.mr.service.listeprixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ListeDePrixs")
public class ListePrixController {

    private final listeprixService ListeDePrixService;

    @Autowired
    public ListePrixController(listeprixService ListeDePrixService) {
        this.ListeDePrixService = ListeDePrixService;
    }

    // Create a new ListeDePrix
    @PostMapping
    public ResponseEntity<ListeDePrix> createListeDePrix(@RequestBody ListeDePrix ListeDePrix) {
        ListeDePrix savedListeDePrix = ListeDePrixService.createListeDePrix(ListeDePrix);
        return ResponseEntity.ok(savedListeDePrix);
    }

    // Get all ListeDePrixs
    @GetMapping
    public List<ListeDePrix> getAllListeDePrixs() {
        return ListeDePrixService.getAllListeDePrixs();
    }

    // Get a single ListeDePrix by ID
    @GetMapping("/{id}")
    public ResponseEntity<ListeDePrix> getListeDePrixById(@PathVariable Long id) {
        return ListeDePrixService.getListePrixById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an ListeDePrix
    @PutMapping("/{id}")
    public ResponseEntity<ListeDePrix> updateListeDePrix(@PathVariable Long id, @RequestBody ListeDePrix ListeDePrix) {
        return ListeDePrixService.updateListeDePrix(id, ListeDePrix)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete an ListeDePrix
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListeDePrix(@PathVariable Long id) {
        if (ListeDePrixService.deleteListeDePrix(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
