package com.gagan.recruitment_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gagan.recruitment_management.repository.JobRepository;
import com.gagan.recruitment_management.model.Job;
import org.springframework.http.ResponseEntity;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public ResponseEntity<?> createJob(Job job) {
        jobRepository.save(job);
        return ResponseEntity.ok("Job created successfully!");
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}
