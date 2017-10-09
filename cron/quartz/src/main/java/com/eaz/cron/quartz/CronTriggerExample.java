package com.eaz.cron.quartz;

import lombok.extern.slf4j.Slf4j;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import org.quartz.CronTrigger;
import static org.quartz.JobBuilder.newJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.impl.StdSchedulerFactory;
import com.eaz.cron.quartz.job.HelloJob;

@Slf4j
public class CronTriggerExample {
    
    private static final String CRON_JOB_EXPRESSION = "0/3 * * * * ?";

    public static void main(String[] args) throws SchedulerException {
        log.info("Begin");

        // Grab the Scheduler instance from the Factory
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail job = newJob(HelloJob.class)
                .withIdentity("job2", "group1")
                .build();

        // Trigger the job to run now based on the cron job expression
        CronTrigger trigger = newTrigger()
                .withIdentity("trigger2", "group1")
                .withSchedule(cronSchedule(CRON_JOB_EXPRESSION))
                .build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);
        
        // and start it off
        scheduler.start();        

        log.info("End");
    }

}
