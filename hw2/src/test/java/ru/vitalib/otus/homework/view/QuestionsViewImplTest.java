package ru.vitalib.otus.homework.view;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.vitalib.otus.homework.model.Answer;
import ru.vitalib.otus.homework.model.Question;
import ru.vitalib.otus.homework.model.Score;
import ru.vitalib.otus.homework.service.EvaluationService;
import ru.vitalib.otus.homework.service.InputOutputService;
import ru.vitalib.otus.homework.service.InputOutputServiceImpl;
import ru.vitalib.otus.homework.service.QuestionService;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class QuestionsViewImplTest {

  @Test
  public void testViewWithPassResult() throws IOException {
    QuestionService questionService = Mockito.mock(QuestionService.class);
    when(questionService.getAllQuestions()).thenReturn(List.of(prepareSimpleQuestion()));
    InputStream userInput = getClass().getResourceAsStream("/user_input.txt");
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    InputOutputService inputOutputService = new InputOutputServiceImpl(userInput, output);
    EvaluationService evaluationService = mock(EvaluationService.class);
    when(evaluationService.evaluate(any(), any())).thenReturn(new Score(1L, 1L, true));
    QuestionsViewImpl questionsView = new QuestionsViewImpl(questionService, inputOutputService, evaluationService);

    questionsView.testUser();
    String programOutput = output.toString();

    assertTrue(programOutput.contains("Hello, what is your name?"));
    assertTrue(programOutput.contains("2 + 2 = ?"));
    assertTrue(programOutput.contains("1) 4"));
    assertTrue(programOutput.contains("2) 5"));
    assertTrue(programOutput.contains("Result:  pass"));
  }

  @Test
  public void testViewWithNotPassResult() throws IOException {
    QuestionService questionService = Mockito.mock(QuestionService.class);
    when(questionService.getAllQuestions()).thenReturn(List.of(prepareSimpleQuestion()));
    InputStream userInput = getClass().getResourceAsStream("/user_input.txt");
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    InputOutputService inputOutputService = new InputOutputServiceImpl(userInput, output);
    EvaluationService evaluationService = mock(EvaluationService.class);
    when(evaluationService.evaluate(any(), any())).thenReturn(new Score(1L, 0L, false));
    QuestionsViewImpl questionsView = new QuestionsViewImpl(questionService, inputOutputService, evaluationService);

    questionsView.testUser();
    String programOutput = output.toString();

    assertTrue(programOutput.contains("Result: not pass"));
  }

  @NotNull
  private Question prepareSimpleQuestion() {
    Question question = new Question();
    question.setId(1);
    question.setText("2 + 2 = ?");
    Answer correctAnswer = new Answer("4", 1, true);
    Answer incorrectAnswer = new Answer("5", 2, false);
    correctAnswer.setQuestion(question);
    incorrectAnswer.setQuestion(question);
    question.setAnswers(List.of(correctAnswer, incorrectAnswer));
    return question;
  }
}