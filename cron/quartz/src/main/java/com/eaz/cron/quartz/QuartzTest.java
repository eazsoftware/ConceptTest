package com.eaz.cron.quartz;

import com.eaz.cron.quartz.job.HelloJob;
import lombok.extern.slf4j.Slf4j;
import static org.quartz.JobBuilder.newJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import org.quartz.Trigger;
import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author javier
 */
@Slf4j
public class QuartzTest {

    public static void main(String[] args) throws InterruptedException {

        log.info("Begin");
        try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            JobDetail job = newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .build();

            // Trigger the job to run now, and then repeat every 40 seconds
            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(5)
                            .repeatForever())
                    .build();

            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);

            // and start it off
            scheduler.start();
            log.info("Scheduler - Start");            
            
            /* (you will also need to allow some time for the job to be triggered
             * and executed before calling shutdown() - for a simple example such 
             * as this, you might just want to add a Thread.sleep(60000) call).*/
            Thread.sleep(20000);
            
            log.info("Scheduler - Shutdown");
            scheduler.shutdown();

        } catch (SchedulerException se) {
            log.error(se.toString());
        }
        log.info("End");
    }
}
