package ru.vitalib.otus.homework.model;

import java.util.List;

public class Question {
    private String text;
    private List<Answer> answers;

    public String getText() {
        return text;
    }

    public Question setText(String text) {
        this.text = text;
        return this;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public Question setAnswers(List<Answer> answers) {
        this.answers = answers;
        return this;
    }
}
