package com.example.demo.Repository;

import com.example.demo.Model.JobListing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobListingRepository  extends CrudRepository<JobListing,Long> {

}
