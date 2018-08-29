package com.example.demo.service;

import com.example.demo.entity.ExchangeRateEntity;
import com.example.demo.repositories.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created By sudhanshu.singh on 8/11/18
 */

//@Service("/service")
@RestController
@RequestMapping(value = "/service")
public class ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @GetMapping(value = "/all")
    public List<ExchangeRateEntity> findAll() {
        return exchangeRateRepository.findAll();
    }

    @GetMapping(value = "/delete")
    public String deleteAll() {
        exchangeRateRepository.deleteAll();
        return "deleted all the data";
    }
}
