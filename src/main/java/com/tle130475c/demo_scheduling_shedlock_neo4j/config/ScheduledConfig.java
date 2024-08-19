package com.tle130475c.demo_scheduling_shedlock_neo4j.config;

import org.neo4j.driver.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import net.javacrumbs.shedlock.provider.neo4j.Neo4jLockProvider;

@Configuration
public class ScheduledConfig {
    @Bean
    Neo4jLockProvider lockProvider(Driver driver) {
        return new Neo4jLockProvider(driver);
    }

    @Bean
    TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();

        taskScheduler.setPoolSize(10);
        taskScheduler.setThreadNamePrefix("CN-Scheduled-");
        taskScheduler.initialize();

        return taskScheduler;
    }
}