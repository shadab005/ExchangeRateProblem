package com.example.demo.job.step;


import com.example.demo.models.ExchangeRateInfo;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class ExchangeRateEventReader extends FlatFileItemReader<ExchangeRateInfo> {

    public ExchangeRateEventReader() {
        /*we may need 1 file which have list of files names
        from which we need to read one complete file at a time. */

        //Set input file
        this.setResource(new ClassPathResource("exchangeRates.csv"));
        //Skip the file header line
        this.setLinesToSkip(1);
        //Line is mapped to item (ExchangeRate2) using setLineMapper(LineMapper)
        this.setLineMapper(new DefaultLineMapper<ExchangeRateInfo>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[]{"FromCurrency", "ToCurrency", "Rate"});
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<ExchangeRateInfo>() {
                    {
                        setTargetType(ExchangeRateInfo.class);
                    }
                });
            }
        });
    }

}
