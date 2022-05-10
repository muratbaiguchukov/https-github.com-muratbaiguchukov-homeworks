package kg.itacademy.dental.service;

import kg.itacademy.dental.model.DentalWorkModel;

import java.util.List;

public interface DentalWorkService {
    DentalWorkModel create(DentalWorkModel dentalWorkModel);

    boolean update(DentalWorkModel dentalWorkModel);

    boolean deleteById(Long id);

    DentalWorkModel getById(Long id);

    List<DentalWorkModel> getAllByDentalWorkName(String dentalWorkName);
}
