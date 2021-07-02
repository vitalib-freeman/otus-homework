package ru.vitalib.otus.homework.converter;

import org.springframework.stereotype.Component;
import ru.vitalib.otus.homework.model.Answer;
import ru.vitalib.otus.homework.model.Question;

import java.util.List;

@Component
public class QuestionConverter {
  private final AnswerConverter answerConverter;

  public QuestionConverter(AnswerConverter answerConverter) {
    this.answerConverter = answerConverter;
  }

  public Question convert(List<String> csvData) {
    Question question = new Question().setText(csvData.get(1));
    question.setId(Integer.valueOf(csvData.get(0)));
    List<Answer> answers = answerConverter.convertAnswers(question, csvData.subList(2, csvData.size()));
    question.setAnswers(answers);
    return question;
  }
}
