package ru.vitalib.otus.homework.model;

public class Answer {
  private Question question;
  private String text;
  private Integer id;
  private boolean isCorrect;

  public Answer(String text, Integer id, boolean isCorrect) {
    this.text = text;
    this.id = id;
    this.isCorrect = isCorrect;
  }

  public Answer(Integer id) {
    this.id = id;
  }

  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public boolean isCorrect() {
    return isCorrect;
  }

  public void setCorrect(boolean correct) {
    isCorrect = correct;
  }
}
