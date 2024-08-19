package com.tle130475c.demo_scheduling_shedlock_neo4j.employee;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;

@Service
@Slf4j
public class EmployeeService {
    @Scheduled(cron = "*/2 * * * * *")
    @SchedulerLock(name = "EmployeeService_sendBirthdayGreetings", lockAtLeastFor = "PT1S")
    public void sendBirthdayGreetings() {
        log.info("Sending birthday greetings to employees");
    }
}