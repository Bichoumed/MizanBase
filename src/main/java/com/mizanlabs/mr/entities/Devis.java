package com.mizanlabs.mr.entities;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Entity
@Table(name = "devis")
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long devisId;

    @Column(name = "devis_amount")
    private Integer amount;

    @Column(name = "devis_date")
    private Date date;

    @Column(name = "devis_discount")
    private Integer discount;

    @Column(name = "devis_note", length = 255)
    private String note;

    @Column(name = "devis_status", length = 255)
    private String status;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;


@OneToMany
    private Set<ligneDevis> ligneDevis;
}
