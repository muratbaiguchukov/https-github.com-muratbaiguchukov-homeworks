package kg.itacademy.dental.service;

import kg.itacademy.dental.model.DentistModel;

import java.util.List;

public interface DentistService {
    DentistModel create(DentistModel dentistModel);

    boolean update(DentistModel dentistModel);

    boolean deleteById(Long id);

    DentistModel getById(Long id);

    List<DentistModel> getAllByDentistFullname(String dentistFullname);

}

