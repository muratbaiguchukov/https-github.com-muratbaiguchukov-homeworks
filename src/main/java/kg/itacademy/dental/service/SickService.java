package kg.itacademy.dental.service;

import kg.itacademy.dental.model.DentistModel;
import kg.itacademy.dental.model.SickModel;

import java.util.List;

public interface SickService {
    SickModel create(SickModel sickModel);

    boolean update(SickModel sickModel);

    boolean deleteById(Long id);

    SickModel getById(Long id);

    List<SickModel> getAllBySickFullname(String sickFullname);
}
