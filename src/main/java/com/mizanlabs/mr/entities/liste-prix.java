package com.mizanlabs.mr.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
    private String itemType;

    @Column(name = "unit", length = 255)
    private String unit;

    // Additional relationships and methods can be added here as needed
}
