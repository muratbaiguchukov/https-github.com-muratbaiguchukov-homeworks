package kg.itacademy.dental.service.impl;

import kg.itacademy.dental.entity.Cabinet;
import kg.itacademy.dental.exception.CabinetModelNullException;
import kg.itacademy.dental.exception.CabinetNotFoundException;
import kg.itacademy.dental.model.CabinetModel;
import kg.itacademy.dental.repository.CabinetRepository;
import kg.itacademy.dental.service.CabinetService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CabinetServiceImpl implements CabinetService{

    private final CabinetRepository cabinetRepository;

    @Override
    public CabinetModel create(CabinetModel cabinetModel) {

        //Валидация
        if (cabinetModel == null) {
            throw new CabinetModelNullException("Create cabinet model is null");
        } else if (Strings.isBlank(cabinetModel.getCodeCabinet())) {
            throw new InvalidParameterException("code cabinet can't be blank");
        }

        //Маппинг
        Cabinet cabinet = new Cabinet();
        cabinet.setCodeCabinet(cabinetModel.getCodeCabinet());
        cabinet.setDentist(cabinetModel.getDentist());
        cabinet = cabinetRepository.save(cabinet);

        // Обратный маппинг
        cabinetModel.setId(cabinet.getId());

        //Вернуть результат
        return cabinetModel;
    }

    @Override
    public boolean update(CabinetModel cabinetModel) {
        //Валидация
        if (cabinetModel == null) {
            throw new CabinetModelNullException("Create cabinet model is null");
        } else if (cabinetModel.getCodeCabinet() == null || cabinetModel.getCodeCabinet().equals("")) {
            throw new InvalidParameterException("code cabinet can't be empty");
        } else if (cabinetModel.getId() == null) {
            throw new InvalidParameterException("cabinet id can't be null");
        }
        //Проверка на то что есть такой кабинет с таким id
        Cabinet existCabinet = cabinetRepository.getById(cabinetModel.getId());
        if (existCabinet == null) {
            throw new CabinetNotFoundException("cabinet not found by id " + cabinetModel.getId());
        }

        //маппим
        existCabinet.setCodeCabinet(cabinetModel.getCodeCabinet());
        existCabinet.setDentist(cabinetModel.getDentist());

        //обновляем
        existCabinet = cabinetRepository.save(existCabinet);

        //Если id не нулл после обновляения то можем считать что update прошел успешно в бд.
        return existCabinet.getId() != null;
    }

    @Override
    public boolean deleteById(Long id) {
        //Валидация
        if (!cabinetRepository.existsById(id)) {
            throw new CabinetNotFoundException("Cabinet not found by id: " + id);
        }

        //Удаление
        cabinetRepository.deleteById(id);

        //Вернется тру если никаких исключений не произошло.
        return true;
    }

    @Override
    public CabinetModel getById(Long id) {
        //Валидация
        if (id == null) {
            throw new InvalidParameterException("Id is null");
        }

        //Ищем в бд с таким айди
        Cabinet existEntity = cabinetRepository.getById(id);

        //Если в бд нет такого айди то вернет null. Значит мы должны выбросить исключение о том что не нашли такого кабинета
        if (existEntity == null) {
            throw new CabinetNotFoundException("cabinet not found by id: " + id);
        }

        //Маппинг
        CabinetModel existModel = new CabinetModel();
        existModel.setId(existEntity.getId());
        existModel.setCodeCabinet(existEntity.getCodeCabinet());
        existModel.setDentist(existEntity.getDentist());

        return existModel;
    }

    @Override
    public List<CabinetModel> getAllByCodeCabinet(String codeCabinet) {
        //Валидация
        if (Strings.isBlank(codeCabinet)) {
            throw new InvalidParameterException("code cabinet is blank");
        }

        //Достаем все кабинеты по коду
        List<Cabinet> cabinetEntityList = cabinetRepository.findAllByCodeCabinet(codeCabinet);

        //Создаем пустой массив моделек
        List<CabinetModel> cabinetModelList = new ArrayList<>();

        //Проходимся по каждому чтобы смаппить все элементы в модельки
        for (Cabinet element : cabinetEntityList) {
            //Маппим по одному каждый энтити в модель
            CabinetModel cabinetModel = new CabinetModel();
            cabinetModel.setId(element.getId());
            cabinetModel.setCodeCabinet(element.getCodeCabinet());
            cabinetModel.setDentist(element.getDentist());

            //добавляем в массив моделек
            cabinetModelList.add(cabinetModel);
        }

        //Возвращаем модельки
        return cabinetModelList;
    }
}
