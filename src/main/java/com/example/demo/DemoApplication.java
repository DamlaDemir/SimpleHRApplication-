package com.example.demo;

import com.example.demo.Model.Applicant;
import com.example.demo.Model.JobListing;
import com.example.demo.Model.User;
import com.example.demo.Repository.ApplicantRepository;
import com.example.demo.Repository.JobListingRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JobListingRepository jobListingRepository;
    @Autowired
    ApplicantRepository applicantRepository;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user=new User("damlademir","1234567");
        user.setName("Damla");
        user.setLastname("Demir");
        userRepository.save(user);

        JobListing jobListing1= new JobListing("Yazılım Stajyeri","Çalışmaya istekli olan","2","10/05/2018");
        JobListing jobListing2 = new JobListing("Senior Developer","Java Spring Bootda uzman","1","20/05/2018");

        jobListingRepository.save(jobListing1);
        jobListingRepository.save(jobListing2);

        Applicant applicant1 = new Applicant("Şaduman Küçük ","şaduman@gmail.com","1111111111","Ankara","düşünce");
        Applicant applicant2 = new Applicant("Özge Algan","ozge@gmail.com","3333333333333","İzmir","düşünce");
        Applicant applicant3 = new Applicant("Fatma Kaya","fatma@gmail.com","2222222222","istanbul","düşünce");
        Applicant applicant4 = new Applicant("Merve Yapnaz","merve@gmail.com","44444444444","Manisa","düşünce");

        applicant2.setJobListing(jobListing1);
        Set applicants = new HashSet<Applicant>();
        applicants.add(applicant2);
        applicants.add(applicant3);
        jobListing2.setApplicants(applicants);

        Set applicants2 = new HashSet<Applicant>();
        applicants2.add(applicant1);
        applicants2.add(applicant4);
        jobListing1.setApplicants(applicants2);

        applicant1.setJobListing(jobListing1);
        applicant2.setJobListing(jobListing2);
        applicant3.setJobListing(jobListing2);
        applicant4.setJobListing(jobListing1);

        applicantRepository.save(applicant1);
        applicantRepository.save(applicant2);
        applicantRepository.save(applicant3);
        applicantRepository.save(applicant4);

    }
}
