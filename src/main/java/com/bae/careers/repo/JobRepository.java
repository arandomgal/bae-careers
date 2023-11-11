package com.bae.careers.repo;

import com.bae.careers.domain.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Integer> {
}
