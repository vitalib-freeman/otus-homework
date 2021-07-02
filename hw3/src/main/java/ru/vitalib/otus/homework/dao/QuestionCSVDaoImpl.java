package ru.vitalib.otus.homework.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;
import ru.vitalib.otus.homework.converter.QuestionConverter;
import ru.vitalib.otus.homework.exceptions.QuestionFileException;
import ru.vitalib.otus.homework.model.Question;
import ru.vitalib.otus.homework.settings.SettingsHolder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Repository
public class QuestionCSVDaoImpl implements QuestionDao {
  private static Logger logger = Logger.getLogger(QuestionCSVDaoImpl.class.getName());
  private final QuestionConverter questionConverter;
  private final SettingsHolder settingsHolder;
  private final ResourceLoader resourceLoader;

  public QuestionCSVDaoImpl(QuestionConverter questionConverter, SettingsHolder settingsHolder, ResourceLoader resourceLoader) {
    this.questionConverter = questionConverter;
    this.settingsHolder = settingsHolder;
    this.resourceLoader = resourceLoader;
  }

  @Override
  public List<Question> getQuestions() {
    Resource questions = resourceLoader.getResource(settingsHolder.getCsvResourcePath());
    try (InputStream resourceAsStream = questions.getInputStream(); CSVReader reader = new CSVReader(new InputStreamReader(resourceAsStream))) {
      return reader.readAll().stream()
         .map(Arrays::asList)
         .map(questionConverter::convert)
         .collect(Collectors.toList());
    } catch (IOException | CsvException e) {
      logger.severe(String.format("Failed to parse csv file %s, error %s", settingsHolder.getCsvResourcePath(), e));
      throw new QuestionFileException(e);
    }
  }
}
