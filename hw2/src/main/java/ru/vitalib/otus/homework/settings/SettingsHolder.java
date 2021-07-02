package ru.vitalib.otus.homework.settings;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SettingsHolder {
  private final int minScore;

  public SettingsHolder(@Value("${minScore}") int minScore) {
    this.minScore = minScore;
  }

  public long getMinimalScore() {
    return minScore;
  }
}
