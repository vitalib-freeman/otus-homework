package ru.vitalib.otus.homework.dao;

import ru.vitalib.otus.homework.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionTestDaoImpl implements QuestionDao {
    private List<Question> questions = new ArrayList<>();

    @Override
    public List<Question> getQuestions() {
        return questions;
    }

}
