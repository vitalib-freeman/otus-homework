package ru.vitalib.otus.homework.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.lang3.NotImplementedException;
import ru.vitalib.otus.homework.converter.QuestionConverter;
import ru.vitalib.otus.homework.model.Question;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class QuestionCSVDaoImpl implements QuestionDao {
  private static Logger logger = Logger.getLogger(QuestionCSVDaoImpl.class.getName());
  private final String csvResourcePath;
  private final QuestionConverter questionConverter;

  public QuestionCSVDaoImpl(String csvResourcePath, QuestionConverter questionConverter) {
    this.csvResourcePath = csvResourcePath;
    this.questionConverter = questionConverter;
  }

  @Override
  public List<Question> getQuestions() {
    InputStream resourceAsStream = getClass().getResourceAsStream(csvResourcePath);
    try (CSVReader reader = new CSVReader(new InputStreamReader(resourceAsStream))) {
      return reader.readAll().stream()
         .map(Arrays::asList)
         .map(questionConverter::convert)
         .collect(Collectors.toList());
    } catch (IOException | CsvException e) {
      logger.severe(String.format("Failed to parse csv file %s, error %s", csvResourcePath, e));
      throw new RuntimeException(e);
    }
  }
}
