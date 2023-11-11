package com.bae.careers.service;

import com.bae.careers.domain.Job;
import com.bae.careers.repo.JobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobBatchService {
    private static final Logger LOGGER = LoggerFactory.getLogger(JobBatchService.class);
    private JobRepository jobRepository;

    @Autowired
    public JobBatchService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void createMultipleJobs(List<Job> jobs) {
        LOGGER.info("Save multiple jobs.");
        jobRepository.saveAll(jobs);
    }
}
