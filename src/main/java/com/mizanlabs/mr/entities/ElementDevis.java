package com.mizanlabs.mr.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "element_devis")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElementDevis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "element_note", length = 255)
    private String elementNote;

    @Column(name = "element_qty")
    private Integer elementQty;

    @Column(name = "element_status", length = 255)
    private String elementStatus;

    // Assuming there's a ManyToOne relationship with Task
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;
    @ManyToOne
    @JoinColumn(name = "liste_de_prix_id") // This column should exist in your `element_devis` table.
    private ListeDePrix listeDePrix;

    // Additional relationships and methods can be added here as needed
}
