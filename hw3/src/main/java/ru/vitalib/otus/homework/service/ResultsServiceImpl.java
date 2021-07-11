package ru.vitalib.otus.homework.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.vitalib.otus.homework.model.Score;

import java.util.Locale;

@Service
public class ResultsServiceImpl implements ResultsService {
  private final InputOutputService inputOutputService;
  private final MessageSource messageSource;

  public ResultsServiceImpl(InputOutputService inputOutputService, MessageSource messageSource) {
    this.inputOutputService = inputOutputService;
    this.messageSource = messageSource;
  }

  @Override
  public void provideResult(Score score, String userName) {
    inputOutputService.write(messageSource.getMessage("user.score", new Object[] {userName, score.getQuestionsWithCorrectAnswer(),
      score.getTotalQuestions()}, Locale.getDefault()));
    String resultTranslation = score.isHasPass() ? "user.pass" : "user.notpass";
    inputOutputService.write(messageSource.getMessage(resultTranslation, null, Locale.getDefault()));
  }
}
