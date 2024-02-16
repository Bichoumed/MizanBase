package com.mizanlabs.mr.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Entity
@Table(name = "ligne-devis")
public class ligneDevis {

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
    private String client_name;

    @Column(name = "item_name", length = 255)
    private String item_name;



    @Column(name = "item_price")
    private BigDecimal item_price;

    @Column(name = "item_type", length = 255)
    private String item_type;

    @Column(name = "unit", length = 255)
    private String item_unit;

    @Column(length = 255)
    private String project_name;

    @Column(name = "task_name", length = 255)
    private String task_name;

    @ManyToOne
    private Devis devis;

}
