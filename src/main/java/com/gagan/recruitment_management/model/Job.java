package com.gagan.recruitment_management.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "jobs")
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String companyName;
    private Date postedOn;

    @ManyToOne // Link to admin user
    private User postedBy;

    // Add getters, setters, constructors here
}
