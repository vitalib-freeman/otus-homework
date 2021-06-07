package ru.vitalib.otus.homework.converter;

import ru.vitalib.otus.homework.model.Answer;
import ru.vitalib.otus.homework.model.Question;

import java.util.List;
import java.util.stream.Collectors;

public class AnswerConverter {
    public static List<Answer> convertAnswers(Question question, List<String> answers) {
        return answers.stream()
                .map(Answer::new)
                .peek(answer -> answer.setQuestion(question))
                .collect(Collectors.toList());
    }
}
