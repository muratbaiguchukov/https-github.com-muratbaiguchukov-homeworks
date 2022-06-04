package kg.itacademy.currency.service.impl;

import kg.itacademy.currency.entity.Currency;
import kg.itacademy.currency.exception.CurrencyModelNullException;
import kg.itacademy.currency.exception.CurrencyNotFoundException;
import kg.itacademy.currency.mapper.CurrencyMapper;
import kg.itacademy.currency.model.CurrencyModel;
import kg.itacademy.currency.repository.CurrencyRepository;
import kg.itacademy.currency.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class CurrencyServiceImpl implements CurrencyService {


    private final CurrencyRepository currencyRepository;

    @Override
    public CurrencyModel create(CurrencyModel currencyModel) {

        if (currencyModel == null) {
            throw new CurrencyModelNullException("Create currency model is null");
        } else if (Strings.isBlank(currencyModel.getCurrencyName())) {
            throw new InvalidParameterException("currency name can't be blank");
        }

        Currency currency = new Currency();
        currency.setName(currencyModel.getCurrencyName());
        currency.setRate(currencyModel.getCurrencyRate());
        currency = currencyRepository.save(currency);

        currencyModel.setId(currency.getId());

        return currencyModel;
    }

    @Override
    public boolean update(CurrencyModel currencyModel) {

        if (currencyModel == null) {
            throw new CurrencyModelNullException("Create currency model is null");
        } else if (currencyModel.getCurrencyName() == null || currencyModel.getCurrencyName().equals("")) {
            throw new InvalidParameterException("currency name can't be empty");
        } else if (currencyModel.getId() == null) {
            throw new InvalidParameterException("currency id can't be null");
        }

        Currency existCurrency = currencyRepository.getById(currencyModel.getId());
        if (existCurrency == null) {
            throw new CurrencyNotFoundException("currency not found by id " + currencyModel.getId());
        }

        existCurrency.setName(currencyModel.getCurrencyName());
        existCurrency.setRate(currencyModel.getCurrencyRate());


        existCurrency = currencyRepository.save(existCurrency);

        return existCurrency.getId() != null;
    }

    @Override
    public boolean deleteById(Long id) {

        if (!currencyRepository.existsById(id)) {
            throw new CurrencyNotFoundException("Currency not found by id: " + id);
        }

        currencyRepository.deleteById(id);

        return true;
    }

    @Override
    public CurrencyModel getById(Long id) {

        if (id == null) {
            throw new InvalidParameterException("Id is null");
        }

        Currency existEntity = currencyRepository.getById(id);

        if (existEntity == null) {
            throw new CurrencyNotFoundException("currency not found by id: " + id);
        }

        CurrencyModel existModel = new CurrencyModel();
        existModel.setId(existEntity.getId());
        existModel.setCurrencyName(existEntity.getName());
        existModel.setCurrencyRate(existEntity.getRate());

        return existModel;
    }

    @Override
    public List<CurrencyModel> getAllByCurrencyName(String currencyName) {

        if (Strings.isBlank(currencyName)) {
            throw new InvalidParameterException("currency name is blank");
        }

        List<Currency> currencyEntityList = currencyRepository.findAllByName(currencyName);

        List<CurrencyModel> currencyModelList = new ArrayList<>();

        for (Currency element : currencyEntityList) {

            CurrencyModel currencyModel = new CurrencyModel();
            currencyModel.setId(element.getId());
            currencyModel.setCurrencyName(element.getName());
            currencyModel.setCurrencyRate(element.getRate());

            currencyModelList.add(currencyModel);
        }


        return currencyModelList;
    }
}
