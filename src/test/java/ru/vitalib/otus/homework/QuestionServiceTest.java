package ru.vitalib.otus.homework;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.vitalib.otus.homework.dao.QuestionTestDaoImpl;
import ru.vitalib.otus.homework.model.Answer;
import ru.vitalib.otus.homework.model.Question;
import ru.vitalib.otus.homework.service.QuestionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionServiceTest {
    @Test
    public void testQuestionService() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AppTest-context.xml");
        QuestionService questionService = context.getBean(QuestionService.class);
        QuestionTestDaoImpl questionTestDao = context.getBean(QuestionTestDaoImpl.class);
        questionTestDao.addQuestion(getSimpleQuestion("Your name?", "Jack"));

        List<Question> questionList = questionService.getAllQuestions();
        Question question = questionList.iterator().next();

        assertEquals(1, questionList.size());
        assertEquals("Your name?", question.getText());
        assertEquals("Jack", question.getAnswers().iterator().next().getText());
    }

    private Question getSimpleQuestion(String question, String answer) {
        return new Question().setText(question).setAnswers(List.of(new Answer(answer)));
    }
}
