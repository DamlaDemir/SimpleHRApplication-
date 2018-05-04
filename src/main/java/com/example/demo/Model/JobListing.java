package com.example.demo.Model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class JobListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @NotEmpty
    @NotBlank
    @Column(name = "jobTitle", nullable = false)
    private String jobTitle;

    @NotEmpty
    @NotBlank
    @Type(type="text")
    @Column(name = "jobDescription", nullable = false)
    private String jobDescription;

    @NotEmpty
    @NotBlank
    @Column(name = "numberOfPeople ", nullable = false)
    private String numberOfPeople;

    @NotEmpty
    @NotBlank
    @Column(name = "lastApplicationDate ", nullable = false)
    private String lastApplicationDate;

    @OneToMany(mappedBy = "jobListing")
    private Set<Applicant> applicants;

    public JobListing() {
    }

    public JobListing(String jobTitle, String jobDescription,String numberOfPeople,String lastApplicationDate) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.numberOfPeople=numberOfPeople;
        this.lastApplicationDate=lastApplicationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLastApplicationDate() {
        return lastApplicationDate;
    }

    public void setLastApplicationDate(String lastApplicationDate) {
        this.lastApplicationDate = lastApplicationDate;
    }

    public String getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(String numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Set<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(Set<Applicant> applicants) {
        this.applicants = applicants;
    }
}
