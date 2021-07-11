package ru.vitalib.otus.homework.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class UserServiceImpl implements UserService {
  private final InputOutputService inputOutputService;
  private final MessageSource messageSource;

  public UserServiceImpl(InputOutputService inputOutputService, MessageSource messageSource) {
    this.inputOutputService = inputOutputService;
    this.messageSource = messageSource;
  }

  @Override
  public String getUserName() {
    inputOutputService.write(messageSource.getMessage("user.greeting", null, Locale.getDefault()));
    return inputOutputService.read();
  }
}
