package ru.vitalib.otus.homework.settings;

import jdk.jfr.SettingDefinition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
public class SettingsHolder {
  private int minScore;
  private String csvResourcePath;

  public int getMinScore() {
    return minScore;
  }

  public void setMinScore(int minScore) {
    this.minScore = minScore;
  }

  public String getCsvResourcePath() {
    return csvResourcePath;
  }

  public void setCsvResourcePath(String csvResourcePath) {
    this.csvResourcePath = csvResourcePath;
  }
}
