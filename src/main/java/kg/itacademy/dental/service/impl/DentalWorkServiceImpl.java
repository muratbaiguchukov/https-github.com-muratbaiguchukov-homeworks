package kg.itacademy.dental.service.impl;

import kg.itacademy.dental.entity.DentalWork;
import kg.itacademy.dental.exception.DentalWorkModelNullException;
import kg.itacademy.dental.exception.DentalWorkNotFoundException;
import kg.itacademy.dental.model.DentalWorkModel;
import kg.itacademy.dental.repository.DentalWorkRepository;
import kg.itacademy.dental.service.DentalWorkService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DentalWorkServiceImpl implements DentalWorkService {

    private final DentalWorkRepository dentalWorkRepository;

    @Override
    public DentalWorkModel create(DentalWorkModel dentalWorkModel) {

        //Валидация
        if (dentalWorkModel == null) {
            throw new DentalWorkModelNullException("Create dentalWork model is null");
        } else if (Strings.isBlank(dentalWorkModel.getDentalWorkName())) {
            throw new InvalidParameterException("dentalWork name can't be blank");
        }

        //Маппинг
        DentalWork dentalWork = new DentalWork();
        dentalWork.setDentalWorkName(dentalWorkModel.getDentalWorkName());
        dentalWork.setDentist(dentalWorkModel.getDentist());
        dentalWork.setPrice(dentalWorkModel.getPrice());
        dentalWork = dentalWorkRepository.save(dentalWork);

        // Обратный маппинг
        dentalWorkModel.setId(dentalWork.getId());

        //Вернуть результат
        return dentalWorkModel;
    }

    @Override
    public boolean update(DentalWorkModel dentalWorkModel) {
        //Валидация
        if (dentalWorkModel == null) {
            throw new DentalWorkModelNullException("Create dentalWork model is null");
        } else if (dentalWorkModel.getDentalWorkName() == null || dentalWorkModel.getDentalWorkName().equals("")) {
            throw new InvalidParameterException("dentalWork name can't be empty");
        } else if (dentalWorkModel.getId() == null) {
            throw new InvalidParameterException("dentalWork id can't be null");
        }
        //Проверка на то что есть такая стоматологическая работа с таким id
        DentalWork existDentalWork = dentalWorkRepository.getById(dentalWorkModel.getId());
        if (existDentalWork == null) {
            throw new DentalWorkNotFoundException("dentalWork not found by id " + dentalWorkModel.getId());
        }

        //маппим
        existDentalWork.setDentalWorkName(dentalWorkModel.getDentalWorkName());
        existDentalWork.setDentist(dentalWorkModel.getDentist());
        existDentalWork.setPrice(dentalWorkModel.getPrice());

        //обновляем
        existDentalWork = dentalWorkRepository.save(existDentalWork);

        //Если id не нулл после обновляения то можем считать что update прошел успешно в бд.
        return existDentalWork.getId() != null;
    }

    @Override
    public boolean deleteById(Long id) {
        //Валидация
        if (!dentalWorkRepository.existsById(id)) {
            throw new DentalWorkNotFoundException("DentalWork not found by id: " + id);
        }

        //Удаление
        dentalWorkRepository.deleteById(id);

        //Вернется тру если никаких исключений не произошло.
        return true;
    }

    @Override
    public DentalWorkModel getById(Long id) {
        //Валидация
        if (id == null) {
            throw new InvalidParameterException("Id is null");
        }

        //Ищем в бд с таким айди
        DentalWork existEntity = dentalWorkRepository.getById(id);

        //Если в бд нет такого айди то вернет null. Значит мы должны выбросить исключение о том что не нашли такой стоматологической работы
        if (existEntity == null) {
            throw new DentalWorkNotFoundException("dentalWork not found by id: " + id);
        }

        //Маппинг
        DentalWorkModel existModel = new DentalWorkModel();
        existModel.setId(existEntity.getId());
        existModel.setDentalWorkName(existEntity.getDentalWorkName());
        existModel.setDentist(existEntity.getDentist());
        existModel.setPrice(existEntity.getPrice());

        return existModel;
    }

    @Override
    public List<DentalWorkModel> getAllByDentalWorkName(String dentalWorkName) {
        //Валидация
        if (Strings.isBlank(dentalWorkName)) {
            throw new InvalidParameterException("dentalWork name is blank");
        }

        //Достаем все стоматологические работы по наименованию
        List<DentalWork> dentalWorkEntityList = dentalWorkRepository.findAllByDentalWorkName(dentalWorkName);

        //Создаем пустой массив моделек
        List<DentalWorkModel> dentalWorkModelList = new ArrayList<>();

        //Проходимся по каждому чтобы смаппить все элементы в модельки
        for (DentalWork element : dentalWorkEntityList) {
            //Маппим по одному каждый энтити в модель
            DentalWorkModel dentalWorkModel = new DentalWorkModel();
            dentalWorkModel.setId(element.getId());
            dentalWorkModel.setDentalWorkName(element.getDentalWorkName());
            dentalWorkModel.setDentist(element.getDentist());
            dentalWorkModel.setPrice(element.getPrice());

            //добавляем в массив моделек
            dentalWorkModelList.add(dentalWorkModel);
        }

        //Возвращаем модельки
        return dentalWorkModelList;
    }
}
