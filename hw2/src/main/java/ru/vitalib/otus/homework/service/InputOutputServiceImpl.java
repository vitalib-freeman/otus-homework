package ru.vitalib.otus.homework.service;

import java.io.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputOutputServiceImpl implements InputOutputService {
  public final BufferedReader reader;
  public final BufferedWriter writer;


  public InputOutputServiceImpl(InputStream inputStream, OutputStream outputStream) {
    reader = new BufferedReader(new InputStreamReader(inputStream));
    writer = new BufferedWriter(new OutputStreamWriter(outputStream));
  }

  @Override
  public void write(String data) throws IOException {
    writer.write(data + "\n");
    writer.flush();
  }

  @Override
  public String read() throws IOException {
    return reader.readLine();
  }

  @Override
  public Set<Integer> getAnswersIds() throws IOException {
    while (true) {
      try {
        return Stream.of(getRawAnswersIds())
           .map(Integer::valueOf)
           .collect(Collectors.toSet());
      } catch (NumberFormatException ex) {
        write("Incorrect input. Please enter answer number(s) separated by comma or space ");
      }
    }
  }

  private String[] getRawAnswersIds() throws IOException {
    return read().trim().split("[\\s,]+");
  }
}
