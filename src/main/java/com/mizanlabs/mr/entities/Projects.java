package com.mizanlabs.mr.entities;
import java.util.Date;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @Column(name = "date_de_creation")
    private Date creationDate;

    @Column(length = 255)
    private String name;

    @Column(name = "project_mo", length = 255)
    private String projectMO;

    @Column(name = "project_moe", length = 255)
    private String projectMOE;

    @Column(name = "project_bct", length = 255)
    private String projectBCT;

    @Column(name = "project_localisation", length = 255)
    private String projectLocation;

    @Column(length = 255)
    private String title;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
