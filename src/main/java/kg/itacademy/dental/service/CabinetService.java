package kg.itacademy.dental.service;

import kg.itacademy.dental.model.CabinetModel;

import java.util.List;

public interface CabinetService {

    CabinetModel create(CabinetModel cabinetModel);

    boolean update(CabinetModel cabinetModel);

    boolean deleteById(Long id);

    CabinetModel getById(Long id);

    List<CabinetModel> getAllByCodeCabinet(String codeCabinet);
}

