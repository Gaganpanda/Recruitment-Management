package com.gagan.recruitment_management.repository;

import com.gagan.recruitment_management.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    // Add custom queries as needed
}
