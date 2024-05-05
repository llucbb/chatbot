package org.llucbb.chatbot.config;

import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Value("${spring.ai.openai.api-key}")
  private String apiKey;

  @Bean
  public OllamaApi ollamaApi() {
    return new OllamaApi();
  }

  @Bean
  public OpenAiApi openAiApi() {
    return new OpenAiApi(apiKey);
  }
}
