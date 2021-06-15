package ru.vitalib.otus.homework.converter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.vitalib.otus.homework.model.Answer;
import ru.vitalib.otus.homework.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnswerConverter {
  public List<Answer> convertAnswers(Question question, List<String> rawAnswers) {
    List<Answer> answers = new ArrayList<>();
    for (int i = 0; i < rawAnswers.size(); i+=3) {
      Answer answer = new Answer(rawAnswers.get(i+1), Integer.valueOf(rawAnswers.get(i)),
         Boolean.parseBoolean(rawAnswers.get(i + 2)));
      answer.setQuestion(question);
      answers.add(answer);
    }
    return answers;
  }
}
