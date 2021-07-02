package ru.vitalib.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.vitalib.otus.homework.model.Answer;
import ru.vitalib.otus.homework.model.Question;
import ru.vitalib.otus.homework.model.Score;
import ru.vitalib.otus.homework.model.UserAnswers;
import ru.vitalib.otus.homework.settings.SettingsHolder;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EvaluationServiceImpl implements EvaluationService {
  private final SettingsHolder settingService;

  public EvaluationServiceImpl(SettingsHolder settingService) {
    this.settingService = settingService;
  }

  @Override
  public Score evaluate(List<Question> allQuestions, UserAnswers userAnswers) {
    Map<Integer, Set<Integer>> correctAnswers = allQuestions.stream()
       .collect(Collectors.toMap(Question::getId, this::getCorrectAnswersIds));
    long totalCorrect = userAnswers.getAnsweredQuestionsIds().stream()
       .filter(questionId -> correctAnswers.get(questionId).containsAll(userAnswers.getAnswersIds(questionId)))
       .filter(questionId -> correctAnswers.get(questionId).size() == userAnswers.getAnswersIds(questionId).size())
       .count();
    boolean hasPass = totalCorrect >= settingService.getMinScore();
    return new Score(allQuestions.size(), (int) totalCorrect, hasPass);
  }

  private Set<Integer> getCorrectAnswersIds(Question question) {
    return question.getAnswers().stream()
       .filter(Answer::isCorrect)
       .map(Answer::getId)
       .collect(Collectors.toSet());
  }
}
