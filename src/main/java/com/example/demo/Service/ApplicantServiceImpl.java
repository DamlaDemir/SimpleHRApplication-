package com.example.demo.Service;

import com.example.demo.Model.Applicant;
import com.example.demo.Model.JobListing;
import com.example.demo.Repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class ApplicantServiceImpl implements ApplicantService {
    private final ApplicantRepository applicantRepository;
    private final JobListingService jobListingService;

    @Autowired
    public ApplicantServiceImpl(ApplicantRepository applicantRepository, JobListingService jobListingService) {
        this.applicantRepository = applicantRepository;
        this.jobListingService = jobListingService;
    }

    //Başvuran kişinin bilgileri sisteme eklenir.
    @Override
    public long addApplicant(Applicant applicant) {
        return applicantRepository.save(applicant).getId();
    }

    //id'ye göre başvuran kişi bulunur.
    @Override
    public Applicant getApplicantById(long id) {
        return applicantRepository.findById(id).get();
    }

    //Başvuru ekleme işlemi gerçekleştirilir.
    @Override
    public void addApplication(long applicantId,long jobListingid) {
        JobListing job=jobListingService.getJobListingDetail(jobListingid);
        Set<Applicant> applicants=job.getApplicants();
        Applicant applicant=getApplicantById(applicantId);
        applicants.add(applicant);
        job.setApplicants(applicants);

        applicant.setJobListing(job);
        applicantRepository.save(applicant);
    }
}
