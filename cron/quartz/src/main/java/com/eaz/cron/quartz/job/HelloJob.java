package com.eaz.cron.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        log.info("Hello, Hola, Alo!");
    }
    
}
