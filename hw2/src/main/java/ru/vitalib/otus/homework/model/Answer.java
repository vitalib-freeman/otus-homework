package ru.vitalib.otus.homework.model;

public class Answer {
  private String text;
  private int id;
  private boolean isCorrect;

  public Answer(String text, Integer id, boolean isCorrect) {
    this.text = text;
    this.id = id;
    this.isCorrect = isCorrect;
  }

  public Answer(Integer id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isCorrect() {
    return isCorrect;
  }

  public void setCorrect(boolean correct) {
    isCorrect = correct;
  }
}
