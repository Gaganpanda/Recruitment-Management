package com.gagan.recruitment_management.controller;

import org.springframework.web.bind.annotation.*;
import com.gagan.recruitment_management.model.Job;
import com.gagan.recruitment_management.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/admin/create")
    public ResponseEntity<?> createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    @GetMapping("/")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }
}
