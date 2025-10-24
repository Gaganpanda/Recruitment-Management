package com.gagan.recruitment_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import com.gagan.recruitment_management.repository.ApplicationRepository;
import com.gagan.recruitment_management.repository.JobRepository;
import com.gagan.recruitment_management.model.Application;
import com.gagan.recruitment_management.model.Job;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobRepository jobRepository;

    public ResponseEntity<?> applyToJob(Long jobId) {
        Application app = new Application();
        Job job = jobRepository.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found"));
        app.setJob(job);
        // Set applicant and status if available
        applicationRepository.save(app);
        return ResponseEntity.ok("Applied successfully!");
    }
}
