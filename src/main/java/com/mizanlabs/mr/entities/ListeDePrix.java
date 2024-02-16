package com.mizanlabs.mr.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "liste_de_prix")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListeDePrix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "note", length = 255)
    private String note;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "item_type", length = 255)
    private String type;

    @Column(name = "unit", length = 255)
    private String unit;

    // Additional relationships and methods can be added here as needed
    @OneToMany(mappedBy = "listeDePrix")
    private Set<ElementDevis> elementDevis;


}
