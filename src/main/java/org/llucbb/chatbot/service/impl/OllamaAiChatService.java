package org.llucbb.chatbot.service.impl;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.util.StringUtil;
import org.llucbb.chatbot.service.ChatService;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
@Slf4j
public class OllamaAiChatService implements ChatService {

  private final OllamaApi ollamaApi;

  @Override
  public String generate(String message, String model) {
    log.debug("->generate");
    var modelObj = StringUtils.isBlank(model) ? OllamaOptions.DEFAULT_MODEL : model;
    var chatClient =
        new OllamaChatClient(ollamaApi)
            .withDefaultOptions(OllamaOptions.create().withModel(modelObj));
    log.debug(modelObj);
    return chatClient.call(message);
  }
}
