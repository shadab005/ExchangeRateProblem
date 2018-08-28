package com.example.demo.models;

import com.example.demo.enums.Currency;
import lombok.Getter;
import lombok.Setter;

/**
 * Created By sudhanshu.singh on 8/11/18
 */

@Getter
@Setter
public class ExchangeRateInfo {

    private Currency fromCurrency;

    private Currency toCurrency;

    private Float rate;
}
