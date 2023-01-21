package Persistance;

import Model.Currency;
import Model.ExchangeRate;


public interface ExchangeRateLoader {
    ExchangeRate load(Currency de, Currency a);
}
