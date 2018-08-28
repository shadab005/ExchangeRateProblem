package com.example.demo.entity;

import com.example.demo.enums.Currency;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ExchangeRateEntity {

    private Long id;

    private String batchId;

    private Currency fromCurrency;

    private Currency toCurrency;

    private Float rate;

    private Date knowledgeDate;

}
