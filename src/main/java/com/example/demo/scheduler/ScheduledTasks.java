package com.example.demo.scheduler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledTasks {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;


    @Scheduled(fixedRate = 5 * 60 * 1000) //run scheduler at every 5 min
    public void exchangeRateScheduler() throws Exception {
        System.out.println(" Job Started at :" + new Date());
        JobParameters param = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
        JobExecution jobExecution = jobLauncher.run(job, param);
        while (jobExecution.isRunning()) {
            System.out.println("...");
            Thread.sleep(2000);
        }
        System.out.println("Job finished with status :" + jobExecution.getStatus());
        return;
    }

}
