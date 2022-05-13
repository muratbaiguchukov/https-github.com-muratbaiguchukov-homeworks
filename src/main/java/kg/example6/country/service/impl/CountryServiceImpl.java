package kg.example6.country.service.impl;

import kg.example6.country.entity.Country;
import kg.example6.country.exception.CountryModelNullException;
import kg.example6.country.exception.CountryNotFoundException;
import kg.example6.country.model.CountryModel;
import kg.example6.country.repository.CountryRepository;
import kg.example6.country.service.CountryService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public CountryModel create(CountryModel countryModel) {

        if (countryModel == null) {
            throw new CountryModelNullException("Create country model is null");
        } else if (Strings.isBlank(countryModel.getCountryName())) {
            throw new InvalidParameterException("country name can't be blank");
        }

        Country country = new Country();
        country.setCountryName(countryModel.getCountryName());
        country.setAlphaCode(countryModel.getAlphaCode());
        country.setCapital(countryModel.getCapital());
        country.setIsActive(true);
        country = countryRepository.save(country);

        countryModel.setId(country.getId());

        return countryModel;
    }

    @Override
    public boolean update(CountryModel countryModel) {

        if (countryModel == null) {
            throw new CountryModelNullException("Create country model is null");
        } else if (countryModel.getCountryName() == null || countryModel.getCountryName().equals("")) {
            throw new InvalidParameterException("country name can't be empty");
        } else if (countryModel.getId() == null) {
            throw new InvalidParameterException("country id can't be null");
        }

        Country existCountry = countryRepository.getById(countryModel.getId());
        if (existCountry == null) {
            throw new CountryNotFoundException("country not found by id " + countryModel.getId());
        }

        existCountry.setCountryName(countryModel.getCountryName());
        existCountry.setAlphaCode(countryModel.getAlphaCode());
        existCountry.setCapital(countryModel.getCapital());

        existCountry = countryRepository.save(existCountry);

        return existCountry.getId() != null;
    }

    @Override
    public boolean deleteById(Long id) {

        if (!countryRepository.existsById(id)) {
            throw new CountryNotFoundException("Country not found by id: " + id);
        }

        countryRepository.deleteById(id);
        return true;
    }

    @Override
    public CountryModel getById(Long id) {

        if (id == null) {
            throw new InvalidParameterException("Id is null");
        }

        Country existEntity = countryRepository.getById(id);

        if (existEntity == null) {
            throw new CountryNotFoundException("country not found by id: " + id);
        }

        CountryModel existModel = new CountryModel();
        existModel.setId(existEntity.getId());
        existModel.setCountryName(existEntity.getCountryName());
        existModel.setAlphaCode(existEntity.getAlphaCode());
        existModel.setCapital(existEntity.getCapital());

        return existModel;
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public List<CountryModel> getAllByCountryName(String countryName) {

        if (Strings.isBlank(countryName)) {
            throw new InvalidParameterException("country name is blank");
        }

        List<Country> countryEntityList = countryRepository.findAllByCountryName(countryName);

        List<CountryModel> countryModelList = new ArrayList<>();


        for (Country element : countryEntityList) {

            CountryModel countryModel = new CountryModel();
            countryModel.setId(element.getId());
            countryModel.setCountryName(element.getCountryName());
            countryModel.setAlphaCode(element.getAlphaCode());
            countryModel.setCapital(element.getCapital());

            countryModelList.add(countryModel);
        }

            return countryModelList;
    }
}

