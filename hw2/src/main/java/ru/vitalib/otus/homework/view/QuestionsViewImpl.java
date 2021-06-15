package ru.vitalib.otus.homework.view;

import org.springframework.stereotype.Controller;
import ru.vitalib.otus.homework.model.Answer;
import ru.vitalib.otus.homework.model.Question;
import ru.vitalib.otus.homework.model.Score;
import ru.vitalib.otus.homework.model.UserAnswers;
import ru.vitalib.otus.homework.service.AcceptableLevelService;
import ru.vitalib.otus.homework.service.EvaluationService;
import ru.vitalib.otus.homework.service.InputOutputService;
import ru.vitalib.otus.homework.service.QuestionService;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class QuestionsViewImpl implements QuestionsView {
  public final QuestionService questionService;
  public final InputOutputService inputOutputService;
  public final EvaluationService evaluationService;
  public final AcceptableLevelService acceptableLevelService;

  public QuestionsViewImpl(QuestionService questionService,
                           InputOutputService inputOutputService,
                           EvaluationService evaluationService,
                           AcceptableLevelService acceptableLevelService) {
    this.questionService = questionService;
    this.inputOutputService = inputOutputService;
    this.evaluationService = evaluationService;
    this.acceptableLevelService = acceptableLevelService;
  }

  @Override
  public void testUser() {
    UserAnswers userAnswers = new UserAnswers();
    try {
      String userName = provideInfoAndGetUserName();
      for (Question question : questionService.getAllQuestions()) {
        userAnswers.addQuestionAnswers(question.getId(), getUserAnswers(userAnswers, question));
      }
      outputResult(userAnswers, userName);
    } catch (IOException e) {
      System.out.println("Error has occurred while writing/reading");
    }
  }

  private void outputResult(UserAnswers userAnswers, String userName) throws IOException {
    Score score = evaluationService.evaluate(questionService.getAllQuestions(), userAnswers);
    inputOutputService.write(String.format("%s, your score is %d of %d", userName, score.getQuestionsWithCorrectAnswer(),
       score.getTotalQuestions()));
    inputOutputService.write(String.format("Result: %s pass", acceptableLevelService.hasPass(score) ? "" : "not"));
  }

  private Set<Integer> getUserAnswers(UserAnswers userAnswers, Question question) throws IOException {
    inputOutputService.write(question.getId() + ") " + question.getText());
    for (Answer answer : question.getAnswers()) {
      inputOutputService.write("\t" + answer.getId() + ") " + answer.getText());
    }
    return getUserAnswers();
  }

  private String provideInfoAndGetUserName() throws IOException {
    inputOutputService.write("Hello, what is your name?");
    String userName = inputOutputService.read();
    inputOutputService.write(String.format("To pass you should answer correctly at least %d questions",
       acceptableLevelService.getMinimalScore()));
    return userName;
  }

  private Set<Integer> getUserAnswers() throws IOException {
    while (true) {
      try {
        return Stream.of(getAnswersIds())
           .map(Integer::valueOf)
           .collect(Collectors.toSet());
      } catch (NumberFormatException ex) {
        inputOutputService.write("Incorrect input. Please enter answer number(s) separated by comma or space ");
      }
    }
  }

  private String[] getAnswersIds() throws IOException {
    return inputOutputService.read().trim().split("[\\s,]+");
  }
}
