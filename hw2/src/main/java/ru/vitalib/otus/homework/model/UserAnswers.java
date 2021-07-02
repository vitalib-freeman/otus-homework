package ru.vitalib.otus.homework.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserAnswers {
  private final Map<Integer, Set<Integer>> questionsAnswers;
  public UserAnswers() {
    this.questionsAnswers = new HashMap<>();
  }

  public UserAnswers(Map<Integer, Set<Integer>> questionsAnswers) {
    this.questionsAnswers = questionsAnswers;
  }
  public void addQuestionAnswers(Integer questionId, Set<Integer> answerIds) {
    questionsAnswers.put(questionId, answerIds);
  }

  public Set<Integer> getAnsweredQuestionsIds() {
    return questionsAnswers.keySet();
  }

  public Set<Integer> getAnswersIds(Integer questionId) {
    return questionsAnswers.get(questionId);
  }
}
