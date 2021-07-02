package ru.vitalib.otus.homework.view;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.vitalib.otus.homework.model.Question;
import ru.vitalib.otus.homework.model.Score;
import ru.vitalib.otus.homework.model.UserAnswers;
import ru.vitalib.otus.homework.service.EvaluationService;
import ru.vitalib.otus.homework.service.QuestionService;
import ru.vitalib.otus.homework.service.ResultsService;
import ru.vitalib.otus.homework.service.TestingService;
import ru.vitalib.otus.homework.service.UserService;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class QuestionsViewImplTest {

  private QuestionService questionService;
  private EvaluationService evaluationService;
  private QuestionsViewImpl questionsView;
  private UserService userService;
  private TestingService testingService;
  private ResultsService resultService;

  @Test
  public void viewTest() {
    questionService = Mockito.mock(QuestionService.class);
    List<Question> questions = List.of(new Question());
    when(questionService.getAllQuestions()).thenReturn(questions);
    userService = Mockito.mock(UserService.class);
    String userName = "User";
    when(userService.getUserName()).thenReturn(userName);
    testingService = Mockito.mock(TestingService.class);
    UserAnswers userAnswers = new UserAnswers();
    when(testingService.getUserAnswers(questions)).thenReturn(userAnswers);
    resultService = Mockito.mock(ResultsService.class);
    evaluationService = Mockito.mock(EvaluationService.class);
    Score resultScore = new Score(1, 1, true);
    when(evaluationService.evaluate(questions, userAnswers)).thenReturn(resultScore);
    questionsView = new QuestionsViewImpl(questionService, evaluationService, userService, testingService, resultService);

    questionsView.testUser();

    verify(userService).getUserName();
    verify(questionService).getAllQuestions();
    verify(testingService).getUserAnswers(questions);
    verify(evaluationService).evaluate(questions, userAnswers);
    verify(resultService).provideResult(resultScore, userName);
  }
}