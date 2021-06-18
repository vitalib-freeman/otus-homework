package ru.vitalib.otus.homework.view;

import org.springframework.stereotype.Controller;
import ru.vitalib.otus.homework.model.Question;
import ru.vitalib.otus.homework.model.Score;
import ru.vitalib.otus.homework.model.UserAnswers;
import ru.vitalib.otus.homework.service.EvaluationService;
import ru.vitalib.otus.homework.service.QuestionService;
import ru.vitalib.otus.homework.service.UserInteractionService;

import java.io.IOException;
import java.util.List;

@Controller
public class QuestionsViewImpl implements QuestionsView {
  private final QuestionService questionService;
  private final EvaluationService evaluationService;
  private final UserInteractionService userInteractionService;

  public QuestionsViewImpl(QuestionService questionService,
                           EvaluationService evaluationService,
                           UserInteractionService userInteractionService) {
    this.questionService = questionService;
    this.evaluationService = evaluationService;
    this.userInteractionService = userInteractionService;
  }

  @Override
  public void testUser() {
    try {
      String userName = userInteractionService.getUserName();
      List<Question> questions = questionService.getAllQuestions();
      UserAnswers userAnswers = userInteractionService.getUserAnswers(questions);
      Score score = evaluationService.evaluate(questionService.getAllQuestions(), userAnswers);
      userInteractionService.provideResult(score, userName);
    } catch (IOException e) {
      System.out.println("Error has occurred while writing/reading");
    }
  }
}
