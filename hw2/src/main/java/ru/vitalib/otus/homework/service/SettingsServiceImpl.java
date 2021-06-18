package ru.vitalib.otus.homework.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SettingsServiceImpl implements SettingsService {
  private final long minScore;

  public SettingsServiceImpl(@Value("${minScore}") long minScore) {
    this.minScore = minScore;
  }

  @Override
  public long getMinimalScore() {
    return minScore;
  }
}
