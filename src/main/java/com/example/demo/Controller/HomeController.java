package com.example.demo.Controller;

import com.example.demo.Model.Applicant;
import com.example.demo.Service.ApplicantService;
import com.example.demo.Service.JobListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    private final JobListingService jobListingService;
    private final ApplicantService applicantService;

    @Autowired
    public HomeController(JobListingService jobListingService, ApplicantService applicantService) {
        this.jobListingService = jobListingService;
        this.applicantService = applicantService;
    }

    //Başvuranların göreceği iş ilanlarının getirilmesi
    @RequestMapping("/getHomepage")
    public ModelAndView getHomepage() {
        return new ModelAndView("homepage", "jobListings", jobListingService.getJobListings());
    }

    //Seçilen iş ilanının detaylarının ve başvuru formunun gösterilmesi.Birden fazla model kullancağımız için map kullanıldı
    @RequestMapping(value ="/homeJobDetail/{id}")
    public ModelAndView getHomeJobDetail(@PathVariable Long id) {
        Map<String, Object> model = new HashMap<>();
        model.put("jobListingDetail", jobListingService.getJobListingDetail(id));
        model.put("applicant", new Applicant());
        return new ModelAndView("homeJobDetail", model);
    }

    //Başvuru yapma
    @RequestMapping(value = "/homeJobDetail/{id}", method = RequestMethod.POST)
    public String addApplication(@ModelAttribute("applicant") Applicant applicant, @PathVariable("id") long jobId) {
        long applicantId=applicantService.addApplicant(applicant);
        applicantService.addApplication(applicantId,jobId);
        return "redirect:/getHomepage";
    }


}
