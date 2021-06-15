package ru.vitalib.otus.homework.model;

public class Score {
  private final long totalQuestions;
  private final long questionsWithCorrectAnswer;

  public Score(Long totalQuestions, long questionsWithCorrectAnswer) {
    this.totalQuestions = totalQuestions;
    this.questionsWithCorrectAnswer = questionsWithCorrectAnswer;
  }

  public long getTotalQuestions() {
    return totalQuestions;
  }

  public long getQuestionsWithCorrectAnswer() {
    return questionsWithCorrectAnswer;
  }

}
