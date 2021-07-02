package ru.vitalib.otus.homework.view;

import org.springframework.stereotype.Controller;
import ru.vitalib.otus.homework.exceptions.InputOutputException;
import ru.vitalib.otus.homework.exceptions.TestAnswerFormatException;
import ru.vitalib.otus.homework.model.Question;
import ru.vitalib.otus.homework.model.Score;
import ru.vitalib.otus.homework.model.UserAnswers;
import ru.vitalib.otus.homework.service.EvaluationService;
import ru.vitalib.otus.homework.service.QuestionService;
import ru.vitalib.otus.homework.service.ResultsService;
import ru.vitalib.otus.homework.service.TestingService;
import ru.vitalib.otus.homework.service.UserService;

import java.util.List;

@Controller
public class QuestionsViewImpl implements QuestionsView {
  private final QuestionService questionService;
  private final EvaluationService evaluationService;
  private final UserService userService;
  private final TestingService testingService;
  private final ResultsService resultService;

  public QuestionsViewImpl(QuestionService questionService,
                           EvaluationService evaluationService,
                           UserService userService,
                           TestingService testingService,
                           ResultsService resultService) {
    this.questionService = questionService;
    this.evaluationService = evaluationService;
    this.userService = userService;
    this.testingService = testingService;
    this.resultService = resultService;
  }

  @Override
  public void testUser() {
    try {
      String userName = userService.getUserName();
      List<Question> questions = questionService.getAllQuestions();
      UserAnswers userAnswers = testingService.getUserAnswers(questions);
      Score score = evaluationService.evaluate(questions, userAnswers);
      resultService.provideResult(score, userName);
    } catch (InputOutputException e) {
      System.out.println("Error has occurred while writing/reading");
      System.exit(1);
    } catch (TestAnswerFormatException e) {
      System.out.println("Error. User response should be provided in numbers separated by comma");
      System.exit(2);
    }
  }
}
