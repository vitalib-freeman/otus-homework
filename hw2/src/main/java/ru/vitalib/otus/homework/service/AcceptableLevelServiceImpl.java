package ru.vitalib.otus.homework.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.vitalib.otus.homework.model.Score;

@Service
public class AcceptableLevelServiceImpl implements AcceptableLevelService {
  private final long minScore;

  public AcceptableLevelServiceImpl(@Value("${minScore}") long minScore) {
    this.minScore = minScore;
  }

  @Override
  public long getMinimalScore() {
    return minScore;
  }

  @Override
  public boolean hasPass(Score score) {
    return score.getQuestionsWithCorrectAnswer() >= minScore;
  }
}
