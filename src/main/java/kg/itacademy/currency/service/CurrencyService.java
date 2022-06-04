package kg.itacademy.currency.service;

import kg.itacademy.currency.model.CurrencyModel;

import java.util.List;

public interface CurrencyService {
    CurrencyModel create(CurrencyModel currencyModel);

    boolean update(CurrencyModel currencyModel);

    boolean deleteById(Long id);

    CurrencyModel getById(Long id);

    List<CurrencyModel> getAllByCurrencyName(String currencyName);
}
