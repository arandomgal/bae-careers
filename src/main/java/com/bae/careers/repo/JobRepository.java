package com.bae.careers.repo;

import com.bae.careers.domain.Job;
import com.bae.careers.domain.Level;
import com.bae.careers.domain.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepository extends CrudRepository<Job, Integer> {
    List<Job> findJobsByCode(String code);
    List<Job> findJobsByLocation(Location location);
    List<Job> findJobsByLevel(Level level);
}
