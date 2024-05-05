package org.llucbb.chatbot.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DocumentService {

  public void storeResponseMessage(String message) {
    try (BufferedWriter writer =
        new BufferedWriter(new FileWriter("/Users/llucbb/Developer/chatResponse.md"))) {
      writer.write(message);
    } catch (IOException e) {
      log.error(e.getMessage(), e);
    }
  }
}
