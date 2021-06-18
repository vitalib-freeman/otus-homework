package ru.vitalib.otus.homework.service;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import ru.vitalib.otus.homework.model.Answer;
import ru.vitalib.otus.homework.model.Question;
import ru.vitalib.otus.homework.model.Score;
import ru.vitalib.otus.homework.model.UserAnswers;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class EvaluationServiceImplTest {

  @Test
  public void testCorrectAnswer() {
    Question question = prepareSimpleQuestion();
    SettingsService settingService = mock(SettingsService.class);

    EvaluationService evaluationService = new EvaluationServiceImpl(settingService);
    Score score = evaluationService.evaluate(List.of(question), new UserAnswers(Map.of(0, Set.of(0))));

    assertEquals(1, score.getQuestionsWithCorrectAnswer());
    assertEquals(1, score.getTotalQuestions());
  }

  @Test
  public void testIncorrectAnswer() {
    Question question = prepareSimpleQuestion();
    SettingsService settingService = mock(SettingsService.class);

    EvaluationService evaluationService = new EvaluationServiceImpl(settingService);
    Score score = evaluationService.evaluate(List.of(question), new UserAnswers(Map.of(0, Set.of(1))));

    assertEquals(0, score.getQuestionsWithCorrectAnswer());
    assertEquals(1, score.getTotalQuestions());
  }

  @Test
  public void testMultipleIncorrectAnswers() {
    Question question = prepareSimpleQuestion();
    SettingsService settingService = mock(SettingsService.class);

    EvaluationService evaluationService = new EvaluationServiceImpl(settingService);
    Score score = evaluationService.evaluate(List.of(question), new UserAnswers(Map.of(0, Set.of(0, 1))));

    assertEquals(0, score.getQuestionsWithCorrectAnswer());
    assertEquals(1, score.getTotalQuestions());
  }

  @NotNull
  private Question prepareSimpleQuestion() {
    Question question = new Question();
    question.setId(0);
    question.setText("2 + 2 = ?");
    Answer correctAnswer = new Answer("4", 0, true);
    Answer incorrectAnswer = new Answer("5", 1, false);
    question.setAnswers(List.of(correctAnswer, incorrectAnswer));
    return question;
  }

}