package kg.itacademy.dental.service.impl;

import kg.itacademy.dental.entity.Sick;
import kg.itacademy.dental.exception.SickModelNullException;
import kg.itacademy.dental.exception.SickNotFoundException;
import kg.itacademy.dental.model.SickModel;
import kg.itacademy.dental.repository.SickRepository;
import kg.itacademy.dental.service.SickService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SickServiceImpl implements SickService {


    private final SickRepository sickRepository;

    @Override
    public SickModel create(SickModel sickModel) {

        //Валидация
        if (sickModel == null) {
            throw new SickModelNullException("Create sick model is null");
        } else if (Strings.isBlank(sickModel.getSickFullname())) {
            throw new InvalidParameterException("sick fullname can't be blank");
        }

        //Маппинг
        Sick sick = new Sick();
        sick.setSickFullname(sickModel.getSickFullname());
        sick.setSickBirthDay(sickModel.getSickBirthDay());
        sick.setSickPayment(sickModel.getSickPayment());
        sick.setSickVisitingTime(sickModel.getSickVisitingTime());
        sick.setDentist(sickModel.getDentist());
        sick.setDentalWork(sickModel.getDentalWork());
        sick.setPhonenumber(sickModel.getPhonenumber());
        sick = sickRepository.save(sick);

        // Обратный маппинг
        sickModel.setId(sick.getId());

        //Вернуть результат
        return sickModel;
    }

    @Override
    public boolean update(SickModel sickModel) {
        //Валидация
        if (sickModel == null) {
            throw new SickModelNullException("Create sick model is null");
        } else if (sickModel.getSickFullname() == null || sickModel.getSickFullname().equals("")) {
            throw new InvalidParameterException("sick fullname can't be empty");
        } else if (sickModel.getId() == null) {
            throw new InvalidParameterException("sick id can't be null");
        }
        //Проверка на то что есть такой больной с таким id
        Sick existSick = sickRepository.getById(sickModel.getId());
        if (existSick == null) {
            throw new SickNotFoundException("sick not found by id " + sickModel.getId());
        }

        //маппим
        existSick.setSickFullname(sickModel.getSickFullname());
        existSick.setSickBirthDay(sickModel.getSickBirthDay());
        existSick.setSickPayment(sickModel.getSickPayment());
        existSick.setSickVisitingTime(sickModel.getSickVisitingTime());
        existSick.setDentist(sickModel.getDentist());
        existSick.setDentalWork(sickModel.getDentalWork());
        existSick.setPhonenumber(sickModel.getPhonenumber());

        //обновляем
        existSick = sickRepository.save(existSick);

        //Если id не нулл после обновляения то можем считать что update прошел успешно в бд.
        return existSick.getId() != null;
    }

    @Override
    public boolean deleteById(Long id) {
        //Валидация
        if (!sickRepository.existsById(id)) {
            throw new SickNotFoundException("Sick not found by id: " + id);
        }

        //Удаление
        sickRepository.deleteById(id);

        //Вернется тру если никаких исключений не произошло.
        return true;
    }

    @Override
    public SickModel getById(Long id) {
        //Валидация
        if (id == null) {
            throw new InvalidParameterException("Id is null");
        }

        //Ищем в бд с таким айди
        Sick existEntity = sickRepository.getById(id);

        //Если в бд нет такого айди то вернет null. Значит мы должны выбросить исключение о том что не нашли такого больного
        if (existEntity == null) {
            throw new SickNotFoundException("sick not found by id: " + id);
        }

        //Маппинг
        SickModel existModel = new SickModel();
        existModel.setId(existEntity.getId());
        existModel.setSickFullname(existEntity.getSickFullname());
        existModel.setSickBirthDay(existEntity.getSickBirthDay());
        existModel.setSickPayment(existEntity.getSickPayment());
        existModel.setSickVisitingTime(existEntity.getSickVisitingTime());
        existModel.setDentist(existEntity.getDentist());
        existModel.setDentalWork(existEntity.getDentalWork());
        existModel.setPhonenumber(existEntity.getPhonenumber());

        return existModel;
    }

    @Override
    public List<SickModel> getAllBySickFullname(String sickFullname) {
        //Валидация
        if (Strings.isBlank(sickFullname)) {
            throw new InvalidParameterException("sick fullname is blank");
        }

        //Достаем всех больных по ФИО
        List <Sick> sickEntityList = sickRepository.findAllBySickFullname(sickFullname);

       //Создаем пустой массив моделек
        List<SickModel> sickModelList = new ArrayList<>();

        //Проходимся по каждому чтобы смаппить все элементы в модельки
        for (Sick element : sickEntityList) {
            //Маппим по одному каждый энтити в модель
            SickModel sickModel = new SickModel();
            sickModel.setId(element.getId());
            sickModel.setSickFullname(element.getSickFullname());
            sickModel.setSickBirthDay(element.getSickBirthDay());
            sickModel.setSickPayment(element.getSickPayment());
            sickModel.setSickVisitingTime(element.getSickVisitingTime());
            sickModel.setDentist(element.getDentist());
            sickModel.setDentalWork(element.getDentalWork());
            sickModel.setPhonenumber(element.getPhonenumber());

            //добавляем в массив моделек
            sickModelList.add(sickModel);
        }

        //Возвращаем модельки
        return sickModelList;
    }
}
