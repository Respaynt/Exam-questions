package org.skypro.Exam_questions.service;

import org.skypro.Exam_questions.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;
import java.util.Set;
import java.util.NoSuchElementException;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;

@Service
public class JavaQuestionService implements QuestionService {
    public final Set<Question> questions = new HashSet<>();
    public final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        questions.add(q);
        return (q);
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new NoSuchElementException("Вопрос не найден: " + question);
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new NoSuchElementException("Нет доступных вопросов");
        }
        int index = random.nextInt(questions.size());
        return new ArrayList<>(questions).get(index);
    }
}