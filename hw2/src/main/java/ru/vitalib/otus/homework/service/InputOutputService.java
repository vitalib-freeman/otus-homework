package ru.vitalib.otus.homework.service;

import java.io.IOException;
import java.util.Set;

public interface InputOutputService {
  void write(String data) throws IOException;
  String read() throws IOException;
  Set<Integer> getAnswersIds() throws IOException;
}
