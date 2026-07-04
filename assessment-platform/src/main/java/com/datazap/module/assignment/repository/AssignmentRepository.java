package com.datazap.module.assignment.repository;

import com.datazap.module.assignment.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> findByCandidateId(Long candidateId);
}