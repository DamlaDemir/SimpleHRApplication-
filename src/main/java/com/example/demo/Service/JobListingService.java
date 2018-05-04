package com.example.demo.Service;

import com.example.demo.Model.JobListing;

public interface JobListingService {
    void addJobListing(JobListing j);
    Iterable<JobListing> getJobListings();
    void deleteJobListing(long id);
    JobListing getJobListingDetail(long id);
}
