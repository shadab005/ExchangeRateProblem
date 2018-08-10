package com.example.demo.reader;

import com.example.demo.models.ExchangeRate2;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;


public class ExchangeRateEventReader extends FlatFileItemReader<ExchangeRate2> {

    public ExchangeRateEventReader() {
        /*we may need 1 file which have list of files names
        from which we need to read one complete file at a time. */

        //Set input file
        this.setResource(new ClassPathResource("exchangeRate.csv"));
        //Skip the file header line
        this.setLinesToSkip(1);
        //Line is mapped to item (ExchangeRate2) using setLineMapper(LineMapper)
        this.setLineMapper(new DefaultLineMapper<ExchangeRate2>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[]{"FromCurrency", "ToCurrency", "Rate"});
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<ExchangeRate2>() {
                    {
                        setTargetType(ExchangeRate2.class);
                    }
                });
            }
        });
    }

}
