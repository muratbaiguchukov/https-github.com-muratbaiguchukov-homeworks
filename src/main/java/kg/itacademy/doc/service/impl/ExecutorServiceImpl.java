package kg.itacademy.doc.service.impl;

import kg.itacademy.doc.entity.Document;
import kg.itacademy.doc.entity.Executor;
import kg.itacademy.doc.exceptions.DocumentModelNullException;
import kg.itacademy.doc.exceptions.DocumentNotFoundException;
import kg.itacademy.doc.exceptions.ExecutorModelNullException;
import kg.itacademy.doc.exceptions.ExecutorNotFoundException;
import kg.itacademy.doc.model.DocumentModel;
import kg.itacademy.doc.model.ExecutorModel;
import kg.itacademy.doc.repository.ExecutorRepository;
import kg.itacademy.doc.service.ExecutorService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
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
        } else if (Strings.isBlank(executorModel.getExecutorFullName())) {
            throw new InvalidParameterException("executor name can't be blank");
        }

        //Маппинг
        Executor executor = new Executor();
        executor.setExecutorFullName(executorModel.getExecutorFullName());
        executor.setJobTitle(executorModel.getJobTitle());
        executor = executorRepository.save(executor);

        // Обратный маппинг
        executorModel.setId(executor.getId());

        //Вернуть результат
        return executorModel;

    }

    @Override
    public boolean update(ExecutorModel executorModel) {
        //Валидация
        if (executorModel == null) {
            throw new ExecutorModelNullException("Create executor model is null");
        } else if (executorModel.getExecutorFullName() == null || executorModel.getExecutorFullName().equals("")) {
            throw new InvalidParameterException("executor name can't be empty");
        } else if (executorModel.getId() == null) {
            throw new InvalidParameterException("executor id can't be null");
        }
        //Проверка на то что есть такой исполнитель с таким id
        Executor existExecutor = executorRepository.getById(executorModel.getId());
        if (existExecutor == null) {
            throw new ExecutorNotFoundException("executor not found by id " + executorModel.getId());
        }

        //маппим
        existExecutor.setExecutorFullName(executorModel.getExecutorFullName());
        existExecutor.setJobTitle(executorModel.getJobTitle());

        //обновляем
        existExecutor = executorRepository.save(existExecutor);

        //Если id не нулл после обновляения то можем считать что update прошел успешно в бд.
        return existExecutor.getId() != null;

    }

    @Override
    public boolean deleteById(Long id) {
        //Валидация
        if (!executorRepository.existsById(id)) {
            throw new ExecutorNotFoundException("Executor not found by id: " + id);
        }

        //Удаление
        executorRepository.deleteById(id);

        //Вернется тру если никаких исключений не произошло.
        return true;

    }

    @Override
    public ExecutorModel getById(Long id) {
        //Валидация
        if (id == null) {
            throw new InvalidParameterException("Id is null");
        }

        //Ищем в бд с таким айди
        Executor existEntity = executorRepository.getById(id);

        //Если в бд нет такого айди то вернет null. Значит мы должны выбросить исключение о том что не нашли такого исполнителя
        if (existEntity == null) {
            throw new ExecutorNotFoundException("executor not found by id: " + id);
        }

        //Маппинг
        ExecutorModel existModel = new ExecutorModel();
        existModel.setId(existEntity.getId());
        existModel.setExecutorFullName(existEntity.getExecutorFullName());
        existModel.setJobTitle(existEntity.getJobTitle());

        return existModel;


    }

    @Override
    public List<ExecutorModel> getAllByExecutorFullName(String executorFullName) {
        //Валидация
        if (Strings.isBlank(executorFullName)) {
            throw new InvalidParameterException("executor name is blank");
        }

        //Достаем всех исполнителей по фамилии
        List<Executor> executorEntityList = executorRepository.findAllByExecutorFullName(executorFullName);

        //Создаем пустой массив моделек
        List<ExecutorModel> executorModelList = new ArrayList<>();

        //Проходимся по каждому чтобы смаппить все элементы в модельки
        for (Executor element : executorEntityList) {
            //Маппим по одному каждый энтити в модель
            ExecutorModel executorModel = new ExecutorModel();
            executorModel.setId(element.getId());
            executorModel.setExecutorFullName(element.getExecutorFullName());
            executorModel.setJobTitle(element.getJobTitle());

            //добавляем в массив моделек
            executorModelList.add(executorModel);
        }

        //Возвращаем модельки
        return executorModelList;
    }

}
