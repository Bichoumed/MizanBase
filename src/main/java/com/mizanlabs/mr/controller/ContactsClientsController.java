package com.mizanlabs.mr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mizanlabs.mr.entities.Contact;
import com.mizanlabs.mr.entities.Client;

import com.mizanlabs.mr.entities.ContactsClients;
import com.mizanlabs.mr.entities.ContactsClientsRequest;
import com.mizanlabs.mr.repository.ClientRepository;
import com.mizanlabs.mr.repository.ContactRepository;
import com.mizanlabs.mr.repository.ContactsClientsRepository;

@RestController
@RequestMapping("/api/contacts-clients")
public class ContactsClientsController {

    @Autowired
    private ContactsClientsRepository contactsClientsRepository;

    @Autowired
    private ContactRepository contactRepository; // Ajoutez l'annotation @Autowired ici

    @Autowired
    private ClientRepository clientRepository; // Ajoutez l'annotation @Autowired ici

    @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
    @PostMapping("/saveOrUpdate")
    public ContactsClients saveOrUpdate(@RequestBody ContactsClientsRequest request) {
        Contact contact = contactRepository.findById(request.getContactId()).orElseThrow(() -> new RuntimeException("Contact not found"));
        Client client = clientRepository.findById(request.getClientId()).orElseThrow(() -> new RuntimeException("Client not found"));

        ContactsClients contactsClients = new ContactsClients();
        contactsClients.setContact(contact);
        contactsClients.setClient(client);
        contactsClients.setIsPrincipal(request.getIsPrincipal());

        return contactsClientsRepository.save(contactsClients);
    }
}
