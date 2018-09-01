package com.example.demo.config;

import com.example.demo.entity.ExchangeRateEntity;
import com.example.demo.job.step.ExchangeRateJobListener;
import com.example.demo.models.ExchangeRateInfo;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Autowired
    private ExchangeRateJobListener exchangeRateJobListener;

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
                   ItemReader<ExchangeRateInfo> itemReader,
                   ItemProcessor<ExchangeRateInfo, ExchangeRateEntity> itemProcessor,
                   ItemWriter<ExchangeRateEntity> itemWriter) {

        Step step = stepBuilderFactory.get("ETL-EC-step")
                .<ExchangeRateInfo, ExchangeRateEntity>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();

        return jobBuilderFactory.get("ETL-EC-Job")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .listener(exchangeRateJobListener)
                .build();

    }
}
