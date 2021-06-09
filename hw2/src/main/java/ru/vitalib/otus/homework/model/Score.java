package ru.vitalib.otus.homework.model;

public class Score {
  private final Long totalQuestions;
  private final Long questionsWithCorrectAnswer;
  private final boolean hasPass;

  public Score(Long totalQuestions, Long questionsWithCorrectAnswer, boolean hasPass) {
    this.totalQuestions = totalQuestions;
    this.questionsWithCorrectAnswer = questionsWithCorrectAnswer;
    this.hasPass = hasPass;
  }

  public Long getTotalQuestions() {
    return totalQuestions;
  }

  public Long getQuestionsWithCorrectAnswer() {
    return questionsWithCorrectAnswer;
  }

  public boolean isHasPass() {
    return hasPass;
  }
}
