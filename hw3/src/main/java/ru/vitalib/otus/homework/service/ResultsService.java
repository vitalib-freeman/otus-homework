package ru.vitalib.otus.homework.service;

import ru.vitalib.otus.homework.model.Score;

public interface ResultsService {
  void provideResult(Score score, String userName);
}
