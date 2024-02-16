package com.mizanlabs.mr.service;

import com.mizanlabs.mr.entities.ListeDePrix;
import com.mizanlabs.mr.repository.ListeDePrixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListeDePrixService {

    private final ListeDePrixRepository listeDePrixRepository;

    @Autowired
    public ListeDePrixService(ListeDePrixRepository listeDePrixRepository) {
        this.listeDePrixRepository = listeDePrixRepository;
    }

    public List<ListeDePrix> getAllListeDePrixs() {
        return listeDePrixRepository.findAll();
    }

    public Optional<ListeDePrix> getListePrixById(Long id) {
        return listeDePrixRepository.findById(id);
    }

    public ListeDePrix createListeDePrix(ListeDePrix listeDePrix) {
        return listeDePrixRepository.save(listeDePrix);
    }

    public Optional<ListeDePrix> updateListeDePrix(Long id, ListeDePrix listeDePrixDetails) {
        return listeDePrixRepository.findById(id).map(listeDePrix -> {
            listeDePrix.setName(listeDePrixDetails.getName());
            listeDePrix.setUnit(listeDePrixDetails.getUnit());
            listeDePrix.setPrice(listeDePrixDetails.getPrice());
            listeDePrix.setType(listeDePrixDetails.getType());
            listeDePrix.setNote(listeDePrixDetails.getNote());
            // Set other fields...
            return listeDePrixRepository.save(listeDePrix);
        });
    }

    public boolean deleteListeDePrix(Long id) {
        boolean exists = listeDePrixRepository.existsById(id);
        if (!exists) {
            return false;
        }
        listeDePrixRepository.deleteById(id);
        return true;
    }
}
