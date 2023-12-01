package com.bae.careers.repo;

import com.bae.careers.domain.Job;
import com.bae.careers.domain.Level;
import com.bae.careers.domain.Location;
import com.bae.careers.domain.Mode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface JobRepository extends CrudRepository<Job, Integer> {
    List<Job> findJobsByCode(String code);
    List<Job> findJobsByLocation(Location location);
    List<Job> findJobsByLevel(Level level);
    List<Job> findJobsByMode(Mode mode);
}
