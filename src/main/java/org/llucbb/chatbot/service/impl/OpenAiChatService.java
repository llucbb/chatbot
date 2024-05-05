package org.llucbb.chatbot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.llucbb.chatbot.service.ChatService;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
@Slf4j
public class OpenAiChatService implements ChatService {

  private final OpenAiApi openAiApi;

  @Override
  public String generate(String message, String model) {
    log.debug("->generate");
    var chatClient =
        new OpenAiChatClient(openAiApi, OpenAiChatOptions.builder().withModel(model).build());
    return chatClient.call(message);
  }
}
