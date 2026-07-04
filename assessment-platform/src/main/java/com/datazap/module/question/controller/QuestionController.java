package com.datazap.module.question.controller;

import com.datazap.module.question.entity.Question;
import com.datazap.module.question.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService service;

    // CREATE QUESTION (ADMIN ONLY)
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Question createQuestion(@RequestBody Question question) {
        return service.createQuestion(question);
    }

    // GET ALL QUESTIONS (ADMIN + CANDIDATE)
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','CANDIDATE')")
    public List<Question> getAllQuestions() {
        return service.getAllQuestions();
    }

    // GET QUESTION BY ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','CANDIDATE')")
    public Question getQuestionById(@PathVariable Long id) {
        return service.getQuestionById(id);
    }

    // GET BY ASSESSMENT
    @GetMapping("/assessment/{assessmentId}")
    @PreAuthorize("hasAnyRole('ADMIN','CANDIDATE')")
    public List<Question> getQuestionsByAssessment(@PathVariable Long assessmentId) {
        return service.getQuestionsByAssessment(assessmentId);
    }

    // UPDATE QUESTION (ADMIN ONLY)
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Question updateQuestion(
            @PathVariable Long id,
            @RequestBody Question question) {
        return service.updateQuestion(id, question);
    }

    // DELETE QUESTION (ADMIN ONLY)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteQuestion(@PathVariable Long id) {
        service.deleteQuestion(id);
        return "Question deleted successfully";
    }
}