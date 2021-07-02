package ru.vitalib.otus.homework.service;

import ru.vitalib.otus.homework.exceptions.InputOutputException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class InputOutputServiceImpl implements InputOutputService {
  public final BufferedReader reader;
  public final BufferedWriter writer;


  public InputOutputServiceImpl(InputStream inputStream, OutputStream outputStream) {
    reader = new BufferedReader(new InputStreamReader(inputStream));
    writer = new BufferedWriter(new OutputStreamWriter(outputStream));
  }

  @Override
  public void write(String data) {

    try {
      writer.write(data + "\n");
      writer.flush();
    } catch (IOException e) {
      throw new InputOutputException(e);
    }
  }

  @Override
  public String read() {
    try {
      return reader.readLine();
    } catch (IOException e) {
      throw new InputOutputException(e);
    }
  }
}
