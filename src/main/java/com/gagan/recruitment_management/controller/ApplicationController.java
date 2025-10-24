package com.gagan.recruitment_management.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.gagan.recruitment_management.service.ApplicationService;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply")
    public ResponseEntity<?> applyToJob(@RequestParam("jobId") Long jobId) {
        return applicationService.applyToJob(jobId);
    }
}
