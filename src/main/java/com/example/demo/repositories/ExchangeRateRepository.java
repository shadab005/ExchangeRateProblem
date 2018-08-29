package com.example.demo.repositories;

import com.example.demo.entity.ExchangeRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, Long> {


}
