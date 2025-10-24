package com.gagan.recruitment_management.repository;

import com.gagan.recruitment_management.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
    // Add custom queries as needed
}
