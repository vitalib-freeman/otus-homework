package ru.vitalib.otus.homework.converter;

import ru.vitalib.otus.homework.model.Answer;
import ru.vitalib.otus.homework.model.Question;

import java.util.List;

public class QuestionConverter {
    public static Question convert(List<String> csvData) {
        Question question = new Question().setText(csvData.get(0));
        List<Answer> answers = AnswerConverter.convertAnswers(question, csvData.subList(1, csvData.size()));
        question.setAnswers(answers);
        return question;
    }
}
