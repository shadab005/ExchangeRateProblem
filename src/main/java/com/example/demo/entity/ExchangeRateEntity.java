package com.example.demo.entity;

import com.example.demo.enums.Currency;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class ExchangeRateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String batchId;

    private Currency fromCurrency;

    private Currency toCurrency;

    private Float rate;

    private Date knowledgeDate;

}
