package kg.example6.country.service;

import kg.example6.country.entity.Country;
import kg.example6.country.model.CountryModel;

import java.util.List;

public interface CountryService {
    CountryModel create(CountryModel countryModel);

    boolean update(CountryModel countryModel);

    boolean deleteById(Long id);

    CountryModel getById(Long id);

    List<CountryModel> getAllByCountryName(String countryName);

    List<Country> getAll();
}
