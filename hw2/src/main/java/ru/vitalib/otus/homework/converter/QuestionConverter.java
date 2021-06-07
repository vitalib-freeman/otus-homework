package ru.vitalib.otus.homework.converter;

import ru.vitalib.otus.homework.model.Answer;
import ru.vitalib.otus.homework.model.Question;

import java.util.List;

public class QuestionConverter {
  private final AnswerConverter answerConverter;

  public QuestionConverter(AnswerConverter answerConverter) {
    this.answerConverter = answerConverter;
  }

  public Question convert(List<String> csvData) {
    Question question = new Question().setText(csvData.get(0));
    List<Answer> answers = answerConverter.convertAnswers(question, csvData.subList(1, csvData.size()));
    question.setAnswers(answers);
    return question;
  }
}
