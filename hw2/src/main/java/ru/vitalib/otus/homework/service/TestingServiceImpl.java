package ru.vitalib.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.vitalib.otus.homework.exceptions.InputOutputException;
import ru.vitalib.otus.homework.exceptions.TestAnswerFormatException;
import ru.vitalib.otus.homework.model.Answer;
import ru.vitalib.otus.homework.model.Question;
import ru.vitalib.otus.homework.model.UserAnswers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TestingServiceImpl implements TestingService {
  private final InputOutputService inputOutputService;

  public TestingServiceImpl(InputOutputService inputOutputService) {
    this.inputOutputService = inputOutputService;
  }

  @Override
  public UserAnswers getUserAnswers(List<Question> questions) {
    UserAnswers userAnswers = new UserAnswers();
    for (Question question : questions) {
      userAnswers.addQuestionAnswers(question.getId(), getUserAnswers(question));
    }
    return userAnswers;
  }

  private Set<Integer> getUserAnswers(Question question) {
    inputOutputService.write(question.getId() + ") " + question.getText());
    for (Answer answer : question.getAnswers()) {
      inputOutputService.write("\t" + answer.getId() + ") " + answer.getText());
    }
    return getAnswersIds();
  }

  public Set<Integer> getAnswersIds() {
    while (true) {
      try {
        return Stream.of(getRawAnswersIds())
          .map(Integer::valueOf)
          .collect(Collectors.toSet());
      } catch (NumberFormatException ex) {
        throw new TestAnswerFormatException();
      }
    }
  }

  private String[] getRawAnswersIds() throws InputOutputException {
    return inputOutputService.read().trim().split("[\\s,]+");
  }
}
