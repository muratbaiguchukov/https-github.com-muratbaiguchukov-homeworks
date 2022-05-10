package kg.itacademy.dental.service.impl;

import kg.itacademy.dental.entity.Dentist;
import kg.itacademy.dental.exception.DentistModelNullException;
import kg.itacademy.dental.exception.DentistNotFoundException;
import kg.itacademy.dental.model.DentistModel;
import kg.itacademy.dental.repository.DentistRepository;
import kg.itacademy.dental.service.DentistService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class DentistServiceImpl implements DentistService {

    private final DentistRepository dentistRepository;

    @Override
    public DentistModel create(DentistModel dentistModel) {

        //Валидация
        if (dentistModel == null) {
            throw new DentistModelNullException("Create dentist model is null");
        } else if (Strings.isBlank(dentistModel.getDentistFullname())) {
            throw new InvalidParameterException("dentist fullname can't be blank");
        }

        //Маппинг
        Dentist dentist = new Dentist();
        dentist.setDentistFullname(dentistModel.getDentistFullname());
        dentist.setOpeningHours(dentistModel.getOpeningHours());
        dentist.setPhonenumber(dentistModel.getPhonenumber());
        dentist = dentistRepository.save(dentist);

        // Обратный маппинг
        dentistModel.setId(dentist.getId());

        //Вернуть результат
        return dentistModel;
    }

    @Override
    public boolean update(DentistModel dentistModel) {
        //Валидация
        if (dentistModel == null) {
            throw new DentistModelNullException("Create dentist model is null");
        } else if (dentistModel.getDentistFullname() == null || dentistModel.getDentistFullname().equals("")) {
            throw new InvalidParameterException("dentist fullname can't be empty");
        } else if (dentistModel.getId() == null) {
            throw new InvalidParameterException("dentist id can't be null");
        }
        //Проверка на то что есть такой dentist с таким id
        Dentist existDentist = dentistRepository.getById(dentistModel.getId());
        if (existDentist == null) {
            throw new DentistNotFoundException("dentist not found by id " + dentistModel.getId());
        }

        //маппим
        existDentist.setDentistFullname(dentistModel.getDentistFullname());
        existDentist.setOpeningHours(dentistModel.getOpeningHours());
        existDentist.setPhonenumber(dentistModel.getPhonenumber());

        //обновляем
        existDentist = dentistRepository.save(existDentist);

        //Если id не нулл после обновляения то можем считать что update прошел успешно в бд.
        return existDentist.getId() != null;
    }

    @Override
    public boolean deleteById(Long id) {
        //Валидация
        if (!dentistRepository.existsById(id)) {
            throw new DentistNotFoundException("Dentist not found by id: " + id);
        }

        //Удаление
        dentistRepository.deleteById(id);

        //Вернеться тру если никаких исключений не произошло.
        return true;
    }

    @Override
    public DentistModel getById(Long id) {
        //Валидация
        if (id == null) {
            throw new InvalidParameterException("Id is null");
        }

        //Ищем в бд с таким айди
        Dentist existEntity = dentistRepository.getById(id);

        //Если в бд нет такого айди то вернет null. Значит мы должны выбросить исключение о том что не нашли такого dentist
        if (existEntity == null) {
            throw new DentistNotFoundException("dentist not found by id: " + id);
        }

        //Маппинг
        DentistModel existModel = new DentistModel();
        existModel.setId(existEntity.getId());
        existModel.setDentistFullname(existEntity.getDentistFullname());
        existModel.setOpeningHours(existEntity.getOpeningHours());
        existModel.setPhonenumber(existEntity.getPhonenumber());

        return existModel;
    }

    @Override
    public List<DentistModel> getAllByDentistFullname(String dentistFullname) {
        //Валидация
        if (Strings.isBlank(dentistFullname)) {
            throw new InvalidParameterException("dentist fullname is blank");
        }

        //Достаем всех стоматологов по ФИО
        List<Dentist> dentistEntityList = dentistRepository.findAllByDentistFullname(dentistFullname);

        //Создаем пустой массив моделек
        List<DentistModel> dentistModelList = new ArrayList<>();

        //Проходимся по каждому чтобы смаппить все элементы в модельки
        for (Dentist element : dentistEntityList) {
            //Маппим по одному каждый энтити в модель
            DentistModel dentistModel = new DentistModel();
            dentistModel.setId(element.getId());
            dentistModel.setDentistFullname(element.getDentistFullname());
            dentistModel.setOpeningHours(element.getOpeningHours());
            dentistModel.setPhonenumber(element.getPhonenumber());

            //добавляем в массив моделек
            dentistModelList.add(dentistModel);
        }

        //Возвращаем модельки
        return dentistModelList;
    }
}