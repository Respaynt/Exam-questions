package org.skypro.Exam_questions.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.Exam_questions.model.Question;

import java.util.Collection;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.AssertionsKt.assertNotNull;

public class JavaQuestionServiceTest {
    private JavaQuestionService service;

    @BeforeEach
    void setUp() {
        service = new JavaQuestionService();
    }

    @Test
    void testAddAndGetAll() {
        service.add("Q1", "A1");
        service.add("Q2", "A2");

        Collection<Question> all = service.getAll();
        assertEquals(2, all.size());
    }

    @Test
    void testRemove() {
        Question q = service.add("Q1", "A1");
        assertEquals(q, service.remove(q));
        assertThrows(NoSuchElementException.class,
                () -> service.remove(q));
    }

    @Test
    void testGetRandomQuestion() {
        service.add("Q1", "A1");
        service.add("Q2", "A2");
        Question q = service.getRandomQuestion();
        assertNotNull(q);
    }
}
