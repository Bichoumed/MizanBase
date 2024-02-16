package com.mizanlabs.mr.entities;


import jakarta.persistence.*;
@Entity
@Table(name = "contacts_clients")
public class ContactsClients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contact_id") // Utilisez @JoinColumn pour mapper la relation
    private Contact contact;

    @ManyToOne
    @JoinColumn(name = "client_id") // Utilisez @JoinColumn pour mapper la relation
    private Client client;

    @Column(name = "is_principal")
    private Boolean isPrincipal;

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Boolean getIsPrincipal() {
        return isPrincipal;
    }

    public void setIsPrincipal(Boolean isPrincipal) {
        this.isPrincipal = isPrincipal;
    }

}
