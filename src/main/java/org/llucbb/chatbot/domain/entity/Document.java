package org.llucbb.chatbot.domain.entity;

import java.nio.charset.StandardCharsets;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Document {

  private long size;
  private String name;
  private String contentType;
  @ToString.Exclude private byte[] content;

  public String getContentString() {
    return new String(content, StandardCharsets.UTF_8);
  }
}
