package ru.vitalib.otus.homework.service;

import ru.vitalib.otus.homework.model.Question;
import ru.vitalib.otus.homework.model.Score;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface EvaluationService {
  Score evaluate(List<Question> questionList, Map<Integer, Set<Integer>> userAnswers);
  Long getMinimalScore();
}
