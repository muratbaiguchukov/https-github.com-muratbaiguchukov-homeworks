package kg.itacademy.doc.service;

import kg.itacademy.doc.entity.Executor;
import kg.itacademy.doc.model.DocumentModel;
import kg.itacademy.doc.model.ExecutorModel;

import java.util.List;

public interface ExecutorService {
    ExecutorModel create(ExecutorModel executorModel);

    boolean update(ExecutorModel executorModel);

    boolean deleteById(Long id);

    ExecutorModel getById(Long id);

    List<ExecutorModel> getAllByExecutorFullName(String executorFullName);
}
