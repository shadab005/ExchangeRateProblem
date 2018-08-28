package com.example.demo.controller;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By sudhanshu.singh on 8/11/18
 */

@RestController
@RequestMapping(value = "/workflow")
public class Workflow {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!!";
    }

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @GetMapping("/run")
    public BatchStatus run() throws Exception {
        System.out.println("Invoking the job");

        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobExecution jobExecution = jobLauncher.run(job, new JobParameters(maps));

        while(jobExecution.isRunning()){
            System.out.println("...");
            Thread.sleep(2000);
        }

        System.out.println("JobExecution : " + jobExecution.getStatus()) ;

        return jobExecution.getStatus();

    }
}