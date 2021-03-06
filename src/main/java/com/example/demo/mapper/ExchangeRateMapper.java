package com.example.demo.mapper;

import com.example.demo.entity.ExchangeRateEntity;
import com.example.demo.models.ExchangeRateInfo;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created By sudhanshu.singh on 8/11/18
 */
@Component
public class ExchangeRateMapper {

    public ExchangeRateInfo convertToBO(ExchangeRateEntity exchangeRateEntity) {
        if (exchangeRateEntity == null) {
            return null;
        }
        ExchangeRateInfo exchangeRateInfo = new ExchangeRateInfo();
        exchangeRateInfo.setFromCurrency(exchangeRateEntity.getFromCurrency());
        exchangeRateInfo.setToCurrency(exchangeRateEntity.getToCurrency());
        exchangeRateInfo.setRate(exchangeRateEntity.getRate());

        return exchangeRateInfo;
    }

    public ExchangeRateEntity convertToEntity(ExchangeRateInfo exchangeRateInfo, String batchId) {
        if (exchangeRateInfo == null) {
            return null;
        }
        ExchangeRateEntity exchangeRateEntity = new ExchangeRateEntity();
        exchangeRateEntity.setFromCurrency(exchangeRateInfo.getFromCurrency());
        exchangeRateEntity.setToCurrency(exchangeRateInfo.getToCurrency());
        exchangeRateEntity.setRate(exchangeRateInfo.getRate());
        exchangeRateEntity.setKnowledgeDate(new Date());
        exchangeRateEntity.setBatchId(batchId);

        return exchangeRateEntity;
    }

}
