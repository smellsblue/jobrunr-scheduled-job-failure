package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.jobrunr.scheduling.BackgroundJob;
import org.jobrunr.scheduling.cron.Cron;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduleJobs {
    @EventListener(ApplicationReadyEvent.class)
    public void scheduleJobs() {
        log.info("Scheduling jobs");
        BackgroundJob.<ScheduleJobs>scheduleRecurrently("my-custom-job", Cron.minutely(), (service) -> service.processJob());
    }

    public void processJob() {
        log.info("Running scheduled job");
    }
}
