package com.mizanlabs.mr.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    // Additional relationships and methods can be added here as needed
}
