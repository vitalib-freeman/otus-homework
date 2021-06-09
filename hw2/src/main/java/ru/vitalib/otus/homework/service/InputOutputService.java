package ru.vitalib.otus.homework.service;

import java.io.IOException;

public interface InputOutputService {
  void write(String data) throws IOException;
  String read() throws IOException;
}
