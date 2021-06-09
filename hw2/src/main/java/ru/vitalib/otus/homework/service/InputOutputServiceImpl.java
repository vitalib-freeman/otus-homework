package ru.vitalib.otus.homework.service;

import java.io.*;

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
}
