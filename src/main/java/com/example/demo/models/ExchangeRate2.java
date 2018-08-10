package com.example.demo.models;

import com.example.demo.enums.Currency;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created By sudhanshu.singh on 8/11/18
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExchangeRate2 {

    @JsonProperty("from_currency")
    private Currency fromCurrency;

    @JsonProperty("to_currency")
    private Currency toCurrency;

    @JsonProperty("rate")
    private Float rate;
}
