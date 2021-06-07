package ru.vitalib.otus.homework.dao;

import ru.vitalib.otus.homework.model.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> getQuestions();
}
