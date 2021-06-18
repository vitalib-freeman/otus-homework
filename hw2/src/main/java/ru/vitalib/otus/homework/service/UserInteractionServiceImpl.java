package ru.vitalib.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.vitalib.otus.homework.model.Answer;
import ru.vitalib.otus.homework.model.Question;
import ru.vitalib.otus.homework.model.Score;
import ru.vitalib.otus.homework.model.UserAnswers;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@Service
public class UserInteractionServiceImpl implements UserInteractionService {
  private static final String WELCOME_MESSAGE = "Hello, what is your name?";
  private static final String SCORE_MESSAGE = "%s, your score is %d of %d";
  private static final String TEST_RESULT_MESSAGE = "Result: %s pass";

  private final InputOutputService inputOutputService;

  public UserInteractionServiceImpl(InputOutputService inputOutputService) {
    this.inputOutputService = inputOutputService;
  }

  @Override
  public String getUserName() throws IOException {
    inputOutputService.write(WELCOME_MESSAGE);
    return inputOutputService.read();
  }

  @Override
  public UserAnswers getUserAnswers(List<Question> questions) throws IOException {
    UserAnswers userAnswers = new UserAnswers();
    for (Question question : questions) {
      userAnswers.addQuestionAnswers(question.getId(), getUserAnswers(question));
    }
    return userAnswers;
  }

  @Override
  public void provideResult(Score score, String userName) throws IOException {
    inputOutputService.write(String.format(SCORE_MESSAGE, userName, score.getQuestionsWithCorrectAnswer(),
       score.getTotalQuestions()));
    inputOutputService.write(String.format(TEST_RESULT_MESSAGE, score.isHasPass() ? "" : "not"));
  }

  private Set<Integer> getUserAnswers(Question question) throws IOException {
    inputOutputService.write(question.getId() + ") " + question.getText());
    for (Answer answer : question.getAnswers()) {
      inputOutputService.write("\t" + answer.getId() + ") " + answer.getText());
    }
    return inputOutputService.getAnswersIds();
  }
}
