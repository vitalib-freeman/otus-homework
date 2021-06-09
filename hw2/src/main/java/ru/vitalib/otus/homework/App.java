package ru.vitalib.otus.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.vitalib.otus.homework.view.QuestionsView;

import java.io.IOException;

@ComponentScan
@PropertySource("classpath:service.properties")
public class App {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        QuestionsView questionsView = context.getBean(QuestionsView.class);
        questionsView.testUser();
    }
}
