package ru.vitalib.otus.homework.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  private static final String WELCOME_MESSAGE = "Hello, what is your name?";
  private final InputOutputService inputOutputService;

  public UserServiceImpl(InputOutputService inputOutputService) {
    this.inputOutputService = inputOutputService;
  }

  @Override
  public String getUserName() {
    inputOutputService.write(WELCOME_MESSAGE);
    return inputOutputService.read();
  }
}
