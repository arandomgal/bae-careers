package com.bae.careers.web;

import com.bae.careers.domain.Job;
import com.bae.careers.exception.DuplicateJobCodeException;
import com.bae.careers.exception.MissingJobCodeException;
import com.bae.careers.repo.JobRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Tag(name = "Job Batch Service", description = "API to manage jobs in batches")
@RestController
@RequestMapping(path = "/batch")
public class JobBatchController {
    private static final ObjectMapper mapper = new ObjectMapper();
    public static final Logger LOGGER = LoggerFactory.getLogger(JobBatchController.class);
    private JobRepository jobRepository;

    @Autowired
    public JobBatchController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Operation(summary = "Create many jobs from a json array.", description = "Create many jobs from a json array.")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createMultipleJobs(String jsonData) throws JsonProcessingException, MissingJobCodeException, DuplicateJobCodeException {
        LOGGER.info("Batch create job entries from JSON data: [" + jsonData + "].");
        List<Job> jobList = Arrays.asList(mapper.readValue(jsonData, Job[].class));
        for (Job job: jobList) {
            String jobCode = job.getCode();
            if (jobCode == null || jobCode.isBlank())
                throw new MissingJobCodeException();
            else if (!jobRepository.findJobsByCode(jobCode).isEmpty())
                throw new DuplicateJobCodeException();
        }
        jobRepository.saveAll(jobList);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(JsonProcessingException.class)
    public String return400(JsonProcessingException ex) {
        LOGGER.error("Unable to parse JSON data.");
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DuplicateJobCodeException.class)
    public String return400(DuplicateJobCodeException ex) {
        LOGGER.error("Failed to batch create jobs due to some entries contain a job code that already exists in the database.");
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingJobCodeException.class)
    public String return400(MissingJobCodeException ex) {
        LOGGER.error("Failed to batch create jobs due to some entries contain a job code that's blank.");
        return ex.getMessage();
    }
}
