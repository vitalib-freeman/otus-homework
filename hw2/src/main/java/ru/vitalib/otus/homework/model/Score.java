package ru.vitalib.otus.homework.model;

public class Score {
  private final long totalQuestions;
  private final long questionsWithCorrectAnswer;
  private final boolean hasPass;

  public Score(Long totalQuestions, long questionsWithCorrectAnswer, boolean hasPass) {
    this.totalQuestions = totalQuestions;
    this.questionsWithCorrectAnswer = questionsWithCorrectAnswer;
    this.hasPass = hasPass;
  }

  public long getTotalQuestions() {
    return totalQuestions;
  }

  public long getQuestionsWithCorrectAnswer() {
    return questionsWithCorrectAnswer;
  }

  public boolean isHasPass() {
    return hasPass;
  }
}
