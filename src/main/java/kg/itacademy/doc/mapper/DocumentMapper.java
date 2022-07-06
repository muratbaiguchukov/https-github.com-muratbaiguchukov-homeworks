package kg.itacademy.doc.mapper;

import kg.itacademy.doc.entity.Document;
import kg.itacademy.doc.model.DocumentCreateModel;
import kg.itacademy.doc.model.DocumentModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DocumentMapper {
    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

    DocumentModel toModel(Document document);

    Document toEntity(DocumentModel document);
    Document toEntity(DocumentCreateModel document);

    List<DocumentModel> toListModel(List<Document> document);
}




