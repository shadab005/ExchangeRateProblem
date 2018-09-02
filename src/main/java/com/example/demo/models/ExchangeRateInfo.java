package com.example.demo.models;

import com.example.demo.enums.Currency;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created By sudhanshu.singh on 8/11/18
 */

@Getter
@Setter
@ApiModel(description = "Class representing Exchange Rate")
public class ExchangeRateInfo {

    @ApiModelProperty(notes = "From currency short name.", example = "USD", required = true, position = 0)
    private Currency fromCurrency;

    @ApiModelProperty(notes = "to currency short name.", example = "EUR", required = true, position = 1)
    private Currency toCurrency;

    @ApiModelProperty(notes = "exchange rate ration from from_currency to to_currency.", example = "1.5", required = true, position = 2)
    private Float rate;
}
