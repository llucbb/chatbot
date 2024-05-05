package org.llucbb.chatbot.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.llucbb.chatbot.dto.MessageEnvelope;
import org.llucbb.chatbot.mapper.DocumentMapper;
import org.llucbb.chatbot.service.ChatService;
import org.llucbb.chatbot.service.impl.DocumentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ChatController {

  private final ChatService chatService;
  private final DocumentService documentService;
  private final DocumentMapper documentMapper;

  @PostMapping(value = "/ai/generate", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public String generate(@ModelAttribute MessageEnvelope messageEnvelope) {
    String message;
    if (messageEnvelope.multipartFile() != null) {
      var document = documentMapper.map(messageEnvelope.multipartFile()).getFirst();
      message = document.getContentString();
    } else if (messageEnvelope.message() != null) {
      message = messageEnvelope.message();
    } else {
      throw new RuntimeException("Message or file with message is mandatory");
    }

    var responseMessage = chatService.generate(message, messageEnvelope.model());
    documentService.storeResponseMessage(responseMessage);
    return responseMessage;
  }
}
