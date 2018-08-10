package com.example.demo.mapper;

import com.example.demo.entity.ExchangeRateEntity;
import com.example.demo.models.ExchangeRate2;
import org.springframework.stereotype.Component;

/**
 * Created By sudhanshu.singh on 8/11/18
 */
@Component
public class ExchangeRateMapper {

    public ExchangeRate2 convertToBO(ExchangeRateEntity exchangeRateEntity) {
        if (exchangeRateEntity == null) {
            return null;
        }
        ExchangeRate2 exchangeRate2 = new ExchangeRate2();
        exchangeRate2.setFromCurrency(exchangeRateEntity.getFromCurrency());
        exchangeRate2.setToCurrency(exchangeRateEntity.getToCurrency());
        exchangeRate2.setRate(exchangeRateEntity.getRate());

        return exchangeRate2;
    }

    public ExchangeRateEntity convertToEntity(ExchangeRate2 exchangeRate2) {
        if (exchangeRate2 == null) {
            return null;
        }
        ExchangeRateEntity exchangeRateEntity = new ExchangeRateEntity();
        exchangeRateEntity.setFromCurrency(exchangeRate2.getFromCurrency());
        exchangeRateEntity.setToCurrency(exchangeRate2.getToCurrency());
        exchangeRateEntity.setRate(exchangeRate2.getRate());

        return exchangeRateEntity;
    }

}
