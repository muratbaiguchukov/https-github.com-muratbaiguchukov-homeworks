package kg.itacademy.doc.service.impl;

import kg.itacademy.doc.entity.Executor;
import kg.itacademy.doc.exceptions.ExecutorModelNullException;
import kg.itacademy.doc.exceptions.ExecutorNotFoundException;
import kg.itacademy.doc.mapper.ExecutorMapper;
import kg.itacademy.doc.model.ExecutorModel;
import kg.itacademy.doc.repository.ExecutorRepository;
import kg.itacademy.doc.service.ExecutorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExecutorServiceImpl implements ExecutorService {

    private final ExecutorRepository executorRepository;

    @Override
    public ExecutorModel create(ExecutorModel executorModel) {
        //Валидация
        if (executorModel == null) {
            throw new ExecutorModelNullException("Create executor model is null");
        }

        //Маппинг
        Executor newEntity = ExecutorMapper.INSTANCE.toEntity(executorModel); // создаем новое entity
        newEntity = executorRepository.save(newEntity);
        return ExecutorMapper.INSTANCE.toModel(newEntity);

    }

    @Override
    public ExecutorModel update(ExecutorModel executorModel) {
        //Валидация
        if (executorModel == null) {
            throw new ExecutorModelNullException("Create executor model is null");
        }

        //Проверка на то что есть такой исполнитель с таким id
        Executor existExecutor = executorRepository.findById(executorModel.getId())
                .orElseThrow(() -> new ExecutorNotFoundException("executor not found by id " + executorModel.getId()));

        //маппим
        ExecutorModel existExecutorModel = ExecutorMapper.INSTANCE.toModel(existExecutor);
        return existExecutorModel;

    }

    @Override
    public boolean deleteById(Long id) {
        //Удаление
        executorRepository.deleteById(id);

        //Вернется тру если никаких исключений не произошло.
        return true;

    }

    @Override
    public ExecutorModel getById(Long id) {
        //Ищем в бд с таким айди
        Executor existEntity = executorRepository.findById(id)
                .orElseThrow(() -> new ExecutorNotFoundException("executor not found by id: " + id));

        //Маппинг
        ExecutorModel existModel = ExecutorMapper.INSTANCE.toModel(existEntity);
        return existModel;

    }

    @Override
    public List<ExecutorModel> getAllByExecutorFullName(String executorFullName) {
        //Достаем всех исполнителей по фамилии
        List<Executor> executorEntityList = executorRepository.findAllByExecutorFullName(executorFullName);

        List<ExecutorModel> executorModelList = ExecutorMapper.INSTANCE.toListModel(executorEntityList);


        //Возвращаем модельки
        return executorModelList;
    }

    @Override
    public List<ExecutorModel> getAll() {
        return  ExecutorMapper.INSTANCE.toListModel(executorRepository.findAll());
    }

}
