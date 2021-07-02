package ru.vitalib.otus.homework.service;

import ru.vitalib.otus.homework.model.Question;
import ru.vitalib.otus.homework.model.UserAnswers;

import java.util.List;

public interface TestingService {
  UserAnswers getUserAnswers(List<Question> questions);
}
