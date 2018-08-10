package com.example.demo.entity;

import com.example.demo.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "exchange_rate")
public class ExchangeRateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "batch_id")
    private String batchId;

    @Column(name = "from_currency")
    @Enumerated(EnumType.STRING)
    private Currency fromCurrency;

    @Column(name = "to_currency")
    @Enumerated(EnumType.STRING)
    private Currency toCurrency;

    @Column(name = "rate")
    private Float rate;

    @Column(name = "knowledge_date")
    private Date knowledgeDate;

}
