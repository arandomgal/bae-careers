package com.bae.careers.repo;

import com.bae.careers.domain.Job;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepository extends CrudRepository<Job, Integer> {
    List<Job> findJobsByCode(String code);
}
