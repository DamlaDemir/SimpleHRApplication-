package com.example.demo.Service;

import com.example.demo.Model.JobListing;
import com.example.demo.Repository.JobListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobListingServiceImpl implements JobListingService {
    private final JobListingRepository jobListingRepository;

    @Autowired
    public JobListingServiceImpl(JobListingRepository jobListingRepository) {
        this.jobListingRepository = jobListingRepository;
    }

    //İş ilanı eklenir
    @Override
    public void addJobListing(JobListing j) {
        JobListing job = new JobListing(j.getJobTitle(),j.getJobDescription(),j.getNumberOfPeople(),j.getLastApplicationDate());
        jobListingRepository.save(job);
    }

    //İş ilanları getirilir.
    @Override
    public Iterable<JobListing> getJobListings() {
        return jobListingRepository.findAll();
    }

    //Gelen id'ye göre iş ilanı silinir.
    @Override
    public void deleteJobListing(long id) {
        jobListingRepository.deleteById(id);
    }

    //Gelen id'ye göre iş ilanının detayları getirilir.
    @Override
    public JobListing getJobListingDetail(long id) {
        return jobListingRepository.findById(id).get();
    }




}
