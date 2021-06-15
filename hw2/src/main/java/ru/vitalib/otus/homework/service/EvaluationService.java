package ru.vitalib.otus.homework.service;

import ru.vitalib.otus.homework.model.Question;
import ru.vitalib.otus.homework.model.Score;
import ru.vitalib.otus.homework.model.UserAnswers;

import java.util.List;

public interface EvaluationService {
  Score evaluate(List<Question> questionList, UserAnswers userAnswers);
}
