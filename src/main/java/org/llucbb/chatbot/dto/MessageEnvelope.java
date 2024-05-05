package org.llucbb.chatbot.dto;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public record MessageEnvelope(String message, List<MultipartFile> multipartFile, String model) {}
