package com.datazap.module.question.service;

import com.datazap.module.question.entity.Question;
import com.datazap.module.question.repository.QuestionRepository;
import com.datazap.module.question.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository repository;

    public Question createQuestion(Question question) {
        return repository.save(question);
    }

    public List<Question> getAllQuestions() {
        return repository.findAll();
    }

    public Question getQuestionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Question not found with id: " + id));
    }

    public List<Question> getQuestionsByAssessment(Long assessmentId) {
        return repository.findByAssessmentId(assessmentId);
    }

    @Transactional
    public Question updateQuestion(Long id, Question updatedQuestion) {

        Question question = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Question not found with id: " + id));

        question.setQuestionText(updatedQuestion.getQuestionText());
        question.setQuestionType(updatedQuestion.getQuestionType());
        question.setOptionA(updatedQuestion.getOptionA());
        question.setOptionB(updatedQuestion.getOptionB());
        question.setOptionC(updatedQuestion.getOptionC());
        question.setOptionD(updatedQuestion.getOptionD());
        question.setCorrectAnswer(updatedQuestion.getCorrectAnswer());
        question.setMarks(updatedQuestion.getMarks());

        return repository.save(question);
    }

    @Transactional
    public void deleteQuestion(Long id) {
        repository.deleteById(id);
    }
}