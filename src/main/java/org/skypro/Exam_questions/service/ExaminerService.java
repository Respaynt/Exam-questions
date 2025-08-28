package org.skypro.Exam_questions.service;

import org.skypro.Exam_questions.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
