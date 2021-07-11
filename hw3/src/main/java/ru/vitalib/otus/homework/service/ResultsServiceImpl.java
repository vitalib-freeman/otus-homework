package ru.vitalib.otus.homework.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.vitalib.otus.homework.model.Score;

@Service
public class ResultsServiceImpl implements ResultsService {
  private static final String SCORE_MESSAGE = "%s, your score is %d of %d";
  private static final String TEST_RESULT_MESSAGE = "Result: %s pass";

  private final InputOutputService inputOutputService;
  private final MessageSource messageSource;

  public ResultsServiceImpl(InputOutputService inputOutputService, MessageSource messageSource) {
    this.inputOutputService = inputOutputService;
    this.messageSource = messageSource;
  }

  @Override
  public void provideResult(Score score, String userName) {
    inputOutputService.write(String.format(messageSource.getMessage(""), userName, score.getQuestionsWithCorrectAnswer(),
      score.getTotalQuestions()));
    inputOutputService.write(String.format(TEST_RESULT_MESSAGE, score.isHasPass() ? "" : "not"));
  }
}
