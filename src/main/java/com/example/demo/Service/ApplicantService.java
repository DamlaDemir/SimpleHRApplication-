package com.example.demo.Service;

import com.example.demo.Model.Applicant;

public interface ApplicantService {
    long addApplicant(Applicant applicant);
    Applicant getApplicantById(long id);
    void addApplication(long applicantId,long jobListingid);
}
