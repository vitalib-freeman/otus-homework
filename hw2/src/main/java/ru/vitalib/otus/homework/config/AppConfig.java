package ru.vitalib.otus.homework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.vitalib.otus.homework.service.InputOutputService;
import ru.vitalib.otus.homework.service.InputOutputServiceImpl;

@Configuration
public class AppConfig {
  @Bean
  public InputOutputService inputOutputService() {
    return new InputOutputServiceImpl(System.in, System.out);
  }
}
