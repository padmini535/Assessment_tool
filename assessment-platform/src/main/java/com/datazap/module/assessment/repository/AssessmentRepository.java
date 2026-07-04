package com.datazap.module.assessment.repository;

import com.datazap.module.assessment.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository
        extends JpaRepository<Assessment, Long> {
}