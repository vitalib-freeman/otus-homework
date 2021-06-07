package ru.vitalib.otus.homework.view;

import ru.vitalib.otus.homework.service.QuestionService;

public class QuestionsViewImpl implements QuestionsView {
    public final QuestionService questionService;

    public QuestionsViewImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void displayAllQuestions() {
        questionService.getAllQuestions().forEach(question -> {
            System.out.println(question.getText());
            question.getAnswers().forEach(answer -> System.out.println('\t' + answer.getText()));
        });
    }
}
