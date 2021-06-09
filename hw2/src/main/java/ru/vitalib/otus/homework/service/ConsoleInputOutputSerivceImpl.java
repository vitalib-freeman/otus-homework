package ru.vitalib.otus.homework.service;

import org.springframework.stereotype.Service;

@Service
public class ConsoleInputOutputSerivceImpl extends InputOutputServiceImpl {
  public ConsoleInputOutputSerivceImpl() {
    super(System.in, System.out);
  }
}
