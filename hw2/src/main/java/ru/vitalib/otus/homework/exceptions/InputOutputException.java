package ru.vitalib.otus.homework.exceptions;

import java.io.IOException;

public class InputOutputException extends RuntimeException{
  public InputOutputException(Throwable e) {
    super(e);
  }
}
