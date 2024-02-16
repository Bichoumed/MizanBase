package com.mizanlabs.mr.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "ligne_devis") // Modifier pour utiliser underscore au lieu de tiret
public class LigneDevis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "element_note", length = 255)
    private String elementNote;

    @Column(name = "element_qty")
    private Integer elementQty;

    @Column(name = "element_status", length = 255)
    private String elementStatus;

    @Column(name = "client_name")
    private String clientName; // Modifié pour respecter camelCase

    @Column(name = "item_name", length = 255)
    private String itemName; // Modifié pour respecter camelCase

    @Column(name = "item_price")
    private BigDecimal itemPrice; // Modifié pour respecter camelCase

    @Column(name = "item_type", length = 255)
    private String itemType; // Modifié pour respecter camelCase

    @Column(name = "unit", length = 255)
    private String itemUnit; // Modifié pour respecter camelCase

    @Column(length = 255)
    private String projectName; // Modifié pour respecter camelCase

    @Column(name = "task_name", length = 255)
    private String taskName; // Modifié pour respecter camelCase


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "devis_id")
    private Devis devis;
}
