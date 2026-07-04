package com.datazap.module.assignment.service;

import com.datazap.module.assignment.entity.Assignment;
import com.datazap.module.assignment.repository.AssignmentRepository;
import com.datazap.module.auth.entity.User;
import com.datazap.module.auth.repository.UserRepository;
import com.datazap.module.assessment.entity.Assessment;
import com.datazap.module.assessment.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssessmentRepository assessmentRepository;

    public Assignment createAssignment(Assignment assignment) {

        Long candidateId = assignment.getCandidate().getId();
        Long assessmentId = assignment.getAssessment().getId();

        User candidate = userRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        Assessment assessment = assessmentRepository.findById(assessmentId)
                .orElseThrow(() -> new RuntimeException("Assessment not found"));

        assignment.setCandidate(candidate);
        assignment.setAssessment(assessment);
        assignment.setAssignedDate(LocalDateTime.now());

        return repository.save(assignment);
    }

    public List<Assignment> getAllAssignments() {
        return repository.findAll();
    }

    public Assignment getAssignment(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
    }

    public List<Assignment> getCandidateAssignments(Long candidateId) {
        return repository.findByCandidateId(candidateId);
    }

    public Assignment updateAssignment(Long id, Assignment assignment) {

        Assignment existing = getAssignment(id);
        existing.setStatus(assignment.getStatus());

        return repository.save(existing);
    }

    public void deleteAssignment(Long id) {
        repository.deleteById(id);
    }
}