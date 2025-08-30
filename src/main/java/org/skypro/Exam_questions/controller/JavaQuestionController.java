package org.skypro.Exam_questions.controller;

import org.skypro.Exam_questions.model.Question;
import org.skypro.Exam_questions.service.JavaQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }

    @PostMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return javaQuestionService.remove(new Question(question, answer));
    }

    @DeleteMapping("/remove")
    public Question remove(@RequestParam String question,
                           @RequestParam String answer) {
        return javaQuestionService.remove(new Question(question, answer));
    }
}
