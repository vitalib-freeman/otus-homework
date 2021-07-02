package ru.vitalib.otus.homework.service;

import ru.vitalib.otus.homework.exceptions.InputOutputException;
import ru.vitalib.otus.homework.exceptions.TestAnswerFormatException;

import java.io.IOException;
import java.util.Set;

public interface InputOutputService {
  void write(String data);
  String read();
}
