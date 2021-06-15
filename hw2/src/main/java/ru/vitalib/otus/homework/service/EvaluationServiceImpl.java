package ru.vitalib.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.vitalib.otus.homework.model.Answer;
import ru.vitalib.otus.homework.model.Question;
import ru.vitalib.otus.homework.model.Score;
import ru.vitalib.otus.homework.model.UserAnswers;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EvaluationServiceImpl implements EvaluationService {
  @Override
  public Score evaluate(List<Question> allQuestions, UserAnswers userAnswers) {
    Map<Integer, Set<Integer>> correctAnswers = allQuestions.stream()
       .collect(Collectors.toMap(Question::getId, this::getCorrectAnswersIds));
    long totalCorrect = userAnswers.getAnsweredQuestionsIds().stream()
       .filter(questionId -> correctAnswers.get(questionId).containsAll(userAnswers.getAnswersIds(questionId)))
       .filter(questionId -> correctAnswers.get(questionId).size() == userAnswers.getAnswersIds(questionId).size())
       .count();
    return new Score((long) allQuestions.size(), totalCorrect);
  }

  private Set<Integer> getCorrectAnswersIds(Question question) {
    return question.getAnswers().stream()
       .filter(Answer::isCorrect)
       .map(Answer::getId)
       .collect(Collectors.toSet());
  }
}
