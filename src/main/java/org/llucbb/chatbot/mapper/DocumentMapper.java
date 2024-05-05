package org.llucbb.chatbot.mapper;

import java.io.IOException;
import java.util.List;
import org.llucbb.chatbot.domain.entity.Document;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.multipart.MultipartFile;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

  List<Document> map(List<MultipartFile> multipartFile);

  @Mapping(target = "name", source = "originalFilename")
  @Mapping(target = "content", source = "bytes")
  Document map(MultipartFile multipartFile) throws IOException;
}
