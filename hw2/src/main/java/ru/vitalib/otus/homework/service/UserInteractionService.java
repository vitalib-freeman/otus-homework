package ru.vitalib.otus.homework.service;

import ru.vitalib.otus.homework.model.Question;
import ru.vitalib.otus.homework.model.Score;
import ru.vitalib.otus.homework.model.UserAnswers;

import java.io.IOException;
import java.util.List;

public interface UserInteractionService {
  String getUserName() throws IOException;
  UserAnswers getUserAnswers(List<Question> questions) throws IOException;
  void provideResult(Score score, String userName) throws IOException;
}
