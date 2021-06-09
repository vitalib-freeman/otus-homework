package ru.vitalib.otus.homework.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.vitalib.otus.homework.model.Answer;
import ru.vitalib.otus.homework.model.Question;
import ru.vitalib.otus.homework.model.Score;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EvaluationServiceImpl implements EvaluationService {
  private final Long minScore;

  public EvaluationServiceImpl(@Value("${minScore}") Long minScore) {
    this.minScore = minScore;
  }

  @Override
  public Score evaluate(List<Question> allQuestions, Map<Integer, Set<Integer>> userAnswers) {
    Map<Integer, Set<Integer>> correctAnswers = allQuestions.stream()
       .collect(Collectors.toMap(Question::getId, this::getCorrectAnswersIds));
    long totalCorrect = userAnswers.entrySet().stream()
       .filter(entry -> correctAnswers.get(entry.getKey()).containsAll(entry.getValue()))
       .filter(entry -> correctAnswers.get(entry.getKey()).size() == entry.getValue().size())
       .count();
    return new Score((long) allQuestions.size(), totalCorrect, totalCorrect >= minScore);
  }

  @Override
  public Long getMinimalScore() {
    return minScore;
  }

  private Set<Integer> getCorrectAnswersIds(Question question) {
    return question.getAnswers().stream()
       .filter(Answer::isCorrect)
       .map(Answer::getId)
       .collect(Collectors.toSet());
  }
}
