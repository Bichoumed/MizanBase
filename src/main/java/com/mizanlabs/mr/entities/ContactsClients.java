package com.mizanlabs.mr.entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "contacts_clients")
public class ContactClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_principal", columnDefinition = "BIT(1)")
    private Boolean isPrincipal;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;
}
