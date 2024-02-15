package com.mizanlabs.mr.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;


@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(name = "task_deadline")
    private Date deadline;

    @Column(name = "task_name", length = 255)
    private String name;

    @Column(name = "task_note", length = 255)
    private String note;

    @Column(name = "task_priority", length = 255)
    private String priority;

    @Column(name = "task_start")
    private Date start;

    @Column(name = "task_status", length = 255)
    private String status;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
