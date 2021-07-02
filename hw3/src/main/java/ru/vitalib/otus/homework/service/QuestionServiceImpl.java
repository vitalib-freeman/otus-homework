package ru.vitalib.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.vitalib.otus.homework.dao.QuestionDao;
import ru.vitalib.otus.homework.model.Question;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionDao.getQuestions();
    }
}
