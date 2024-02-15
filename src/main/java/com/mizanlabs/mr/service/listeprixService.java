package com.mizanlabs.mr.service;


import com.mizanlabs.mr.entities.ListeDePrix;
import com.mizanlabs.mr.repository.ListeDePrixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class listeprixService {

    private final ListeDePrixRepository ListeDePrixRepository;

    @Autowired
    public listeprixService(ListeDePrixRepository ListeDePrixRepository) {
        this.ListeDePrixRepository = ListeDePrixRepository;
    }

    public List<ListeDePrix> getAllListeDePrixs() {
        return ListeDePrixRepository.findAll();
    }

    public Optional<ListeDePrix> getListePrixById(Long id) {
        return ListeDePrixRepository.findById(id);
    }

    public ListeDePrix createListeDePrix(ListeDePrix ListeDePrix) {
        return ListeDePrixRepository.save(ListeDePrix);
    }

    public Optional<ListeDePrix> updateListeDePrix(Long id, ListeDePrix ListeDePrixDetails) {
        return ListeDePrixRepository.findById(id).map(ListeDePrix -> {
            ListeDePrix.setName(ListeDePrixDetails.getName());
            ListeDePrix.setUnit(ListeDePrixDetails.getUnit());
            ListeDePrix.setPrice(ListeDePrixDetails.getPrice());
            ListeDePrix.setType(ListeDePrixDetails.getType());
            ListeDePrix.setNote(ListeDePrixDetails.getNote());
            // Set other fields...
            return ListeDePrixRepository.save(ListeDePrix);
        });
    }

    public boolean deleteListeDePrix(Long id) {
        boolean exists = ListeDePrixRepository.existsById(id);
        if (!exists) {
            return false;
        }
        ListeDePrixRepository.deleteById(id);
        return true;
    }
}
