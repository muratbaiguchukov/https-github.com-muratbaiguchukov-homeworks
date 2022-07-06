package kg.itacademy.doc.mapper;

import kg.itacademy.doc.entity.Executor;
import kg.itacademy.doc.model.ExecutorModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface ExecutorMapper {
    ExecutorMapper INSTANCE = Mappers.getMapper(ExecutorMapper.class);

    ExecutorModel toModel(Executor executor);

    Executor toEntity(ExecutorModel executor);

    List<ExecutorModel> toListModel(List<Executor> executor);
}
