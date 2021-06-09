package ru.vitalib.otus.homework.service;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import ru.vitalib.otus.homework.model.Answer;
import ru.vitalib.otus.homework.model.Question;
import ru.vitalib.otus.homework.model.Score;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class EvaluationServiceImplTest {

  @Test
  public void testCorrectAnswer() {
    Question question = prepareSimpleQuestion();

    EvaluationService evaluationService = new EvaluationServiceImpl(3L);
    Score score = evaluationService.evaluate(List.of(question), Map.of(0, Set.of(0)));

    assertEquals(1, score.getQuestionsWithCorrectAnswer());
    assertEquals(1, score.getTotalQuestions());
  }

  @Test
  public void testIncorrectAnswer() {
    Question question = prepareSimpleQuestion();

    EvaluationService evaluationService = new EvaluationServiceImpl(1L);
    Score score = evaluationService.evaluate(List.of(question), Map.of(0, Set.of(1)));

    assertEquals(0, score.getQuestionsWithCorrectAnswer());
    assertEquals(1, score.getTotalQuestions());
  }

  @Test
  public void testMultipleIncorrectAnswers() {
    Question question = prepareSimpleQuestion();

    EvaluationService evaluationService = new EvaluationServiceImpl(1L);
    Score score = evaluationService.evaluate(List.of(question), Map.of(0, Set.of(0, 1)));

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
    correctAnswer.setQuestion(question);
    incorrectAnswer.setQuestion(question);
    question.setAnswers(List.of(correctAnswer, incorrectAnswer));
    return question;
  }

}