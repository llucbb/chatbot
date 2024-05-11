package org.llucbb.chatbot.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ai.openai.api.OpenAiApi;

@ExtendWith(MockitoExtension.class)
class OpenAiChatServiceTest {

  private OpenAiChatService openAiChatService;

  @Mock private OpenAiApi openAiApi;

  @BeforeEach
  void init() {
    openAiChatService = new OpenAiChatService(openAiApi);
  }
}
