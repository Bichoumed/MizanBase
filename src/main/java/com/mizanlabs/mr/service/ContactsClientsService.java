package com.mizanlabs.mr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mizanlabs.mr.entities.ContactsClients;
import com.mizanlabs.mr.repository.ContactsClientsRepository;
@Service
public class ContactsClientsService {
    @Autowired
    private ContactsClientsRepository contactsClientsRepository;

    public ContactsClientsService(ContactsClientsRepository contactsClientsRepository) {
        this.contactsClientsRepository = contactsClientsRepository;
    }

    public ContactsClients saveOrUpdate(ContactsClients contactsClients) {
        return contactsClientsRepository.save(contactsClients);
    }

    public void deleteByClientIdAndContactId(Long clientId, Long contactId) {
        contactsClientsRepository.deleteByClientIdAndContactId(clientId, contactId);
    }

}
