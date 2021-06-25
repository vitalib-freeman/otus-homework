package ru.vitalib.otus.homework.model;

public class Score {
  private final int totalQuestions;
  private final int questionsWithCorrectAnswer;
  private final boolean hasPass;

  public Score(int totalQuestions, int questionsWithCorrectAnswer, boolean hasPass) {
    this.totalQuestions = totalQuestions;
    this.questionsWithCorrectAnswer = questionsWithCorrectAnswer;
    this.hasPass = hasPass;
  }

  public int getTotalQuestions() {
    return totalQuestions;
  }

  public int getQuestionsWithCorrectAnswer() {
    return questionsWithCorrectAnswer;
  }

  public boolean isHasPass() {
    return hasPass;
  }
}
