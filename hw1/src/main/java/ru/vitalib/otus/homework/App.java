package ru.vitalib.otus.homework;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.vitalib.otus.homework.view.QuestionsView;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        QuestionsView questionsView = context.getBean(QuestionsView.class);
        questionsView.displayAllQuestions();
    }
}
