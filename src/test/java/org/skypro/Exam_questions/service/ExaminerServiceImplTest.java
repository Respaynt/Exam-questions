package org.skypro.Exam_questions.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.Exam_questions.model.Question;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExaminerServiceImplTest {
    private JavaQuestionService questionService;
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        questionService = new JavaQuestionService();
        examinerService = new ExaminerServiceImpl(questionService);

        questionService.add("Q1", "A1");
        questionService.add("Q2", "A2");
        questionService.add("Q3", "A3");
    }

    @Test
    void testGetQuestionsValid() {
        Collection<Question> result = examinerService.getQuestions(2);
        assertEquals(2, result.size());
    }

    @Test
    void testGetQuestionsTooMany() {
        assertThrows(ResponseStatusException.class,
                () -> examinerService.getQuestions(10));
    }
}
