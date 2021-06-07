package ru.vitalib.otus.homework;

import org.junit.jupiter.api.Test;
import ru.vitalib.otus.homework.dao.QuestionDao;
import ru.vitalib.otus.homework.model.Answer;
import ru.vitalib.otus.homework.model.Question;
import ru.vitalib.otus.homework.service.QuestionService;
import ru.vitalib.otus.homework.service.QuestionServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class QuestionServiceTest {
  @Test
  public void testQuestionService() {
    QuestionDao questionDaoMock = mock(QuestionDao.class);
    when(questionDaoMock.getQuestions()).thenReturn(List.of(getSimpleQuestion("Your name?", "Jack")));
    QuestionService questionService = new QuestionServiceImpl(questionDaoMock);

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
