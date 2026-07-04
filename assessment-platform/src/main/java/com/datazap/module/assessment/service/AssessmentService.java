package com.datazap.module.assessment.service;

import com.datazap.module.assessment.entity.Assessment;
import com.datazap.module.assessment.repository.AssessmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository repository;

    public Assessment createAssessment(
            Assessment assessment) {

        return repository.save(assessment);
    }

    public List<Assessment> getAllAssessments() {

        return repository.findAll();
    }

    public Assessment getAssessmentById(Long id) {

        return repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Assessment not found"));
    }

    public Assessment updateAssessment(
        Long id,
        Assessment updatedAssessment){

    Assessment assessment =
            repository.findById(id)
                    .orElseThrow(
                            () -> new RuntimeException(
                                    "Assessment not found"));

    assessment.setTitle(
            updatedAssessment.getTitle());

    assessment.setDescription(
            updatedAssessment.getDescription());

    assessment.setDuration(
            updatedAssessment.getDuration());

    return repository.save(assessment);
}

public void deleteAssessment(Long id) {

    Assessment assessment =
            repository.findById(id)
                    .orElseThrow(
                            () -> new RuntimeException(
                                    "Assessment not found"));

    repository.delete(assessment);
}

}