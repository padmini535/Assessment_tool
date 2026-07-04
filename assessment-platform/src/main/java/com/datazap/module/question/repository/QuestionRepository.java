package com.datazap.module.question.repository;

import com.datazap.module.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository
        extends JpaRepository<Question, Long> {

    List<Question> findByAssessmentId(Long assessmentId);
}