package com.example.demo.Model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @NotEmpty
    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty
    @NotBlank
    @Column(name = "email", nullable = false)
    private String email;

    @NotEmpty
    @NotBlank
    @Column(name = "phone ", nullable = false)
    private String phone;

    @NotEmpty
    @NotBlank
    @Column(name = "address ", nullable = false)
    private String address;

    @NotEmpty
    @NotBlank
    @Type(type="text")
    @Column(name = "thoughtsOnJob ", nullable = false)
    private String thoughtsOnJob;

    @ManyToOne
    @JoinColumn(name = "jobId")
    private JobListing jobListing;

    public Applicant() {
    }

    public Applicant(String name, String email,String phone,String address,String thoughtsOnJob) {
        this.name = name;
        this.email = email;
        this.phone=phone;
        this.address=address;
        this.thoughtsOnJob=thoughtsOnJob;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public JobListing getJobListing() {
        return jobListing;
    }

    public void setJobListing(JobListing jobListing) {
        this.jobListing = jobListing;
    }

    public String getThoughtsOnJob() {
        return thoughtsOnJob;
    }

    public void setThoughtsOnJob(String thoughtsOnJob) {
        this.thoughtsOnJob = thoughtsOnJob;
    }

}
