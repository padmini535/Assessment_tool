package com.datazap.module.assessment.controller;

import com.datazap.module.assessment.entity.Assessment;
import com.datazap.module.assessment.service.AssessmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {

    @Autowired
    private AssessmentService service;

    @PostMapping
    public Assessment createAssessment(
            @RequestBody Assessment assessment) {

        return service.createAssessment(assessment);
    }

    @GetMapping
    public List<Assessment> getAllAssessments() {

        return service.getAllAssessments();
    }

    @GetMapping("/{id}")
    public Assessment getAssessmentById(
            @PathVariable Long id) {

        return service.getAssessmentById(id);
    }

    @PutMapping("/{id}")
public Assessment updateAssessment(
        @PathVariable Long id,
        @RequestBody Assessment assessment){

    return service.updateAssessment(
            id,
            assessment);
}

@DeleteMapping("/{id}")
public String deleteAssessment(
        @PathVariable Long id) {

    service.deleteAssessment(id);

    return "Assessment deleted successfully";
}

}