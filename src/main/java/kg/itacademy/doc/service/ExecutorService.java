package kg.itacademy.doc.service;

import kg.itacademy.doc.model.ExecutorModel;

import java.util.List;

public interface ExecutorService {
    ExecutorModel create(ExecutorModel executorModel); // создать исполнителя

    ExecutorModel update(ExecutorModel executorModel); // изменить исполнителя

    boolean deleteById(Long id); // удаление исполнителя по id

    ExecutorModel getById(Long id); // получить исполнителя по id

    List<ExecutorModel> getAllByExecutorFullName(String executorFullName); // получить всех исполнителей по фамилии


    List<ExecutorModel> getAll();
}
