package ru.vitalib.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.vitalib.otus.homework.model.Score;

@Service
public class ResultsServiceImpl implements ResultsService {
  private static final String SCORE_MESSAGE = "%s, your score is %d of %d";
  private static final String TEST_RESULT_MESSAGE = "Result: %s pass";

  private final InputOutputService inputOutputService;

  public ResultsServiceImpl(InputOutputService inputOutputService) {
    this.inputOutputService = inputOutputService;
  }

  @Override
  public void provideResult(Score score, String userName) {
    inputOutputService.write(String.format(SCORE_MESSAGE, userName, score.getQuestionsWithCorrectAnswer(),
      score.getTotalQuestions()));
    inputOutputService.write(String.format(TEST_RESULT_MESSAGE, score.isHasPass() ? "" : "not"));
  }
}
