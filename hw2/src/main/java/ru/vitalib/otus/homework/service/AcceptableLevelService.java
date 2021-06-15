package ru.vitalib.otus.homework.service;

import ru.vitalib.otus.homework.model.Score;

public interface AcceptableLevelService {
  long getMinimalScore();
  boolean hasPass(Score score);
}
