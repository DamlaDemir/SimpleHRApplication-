package com.example.demo.Controller;

import com.example.demo.Model.JobListing;
import com.example.demo.Service.JobListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AdminController {
    private final JobListingService jobListingService;

    @Autowired
    public AdminController(JobListingService jobListingService) {
        this.jobListingService = jobListingService;
    }

    //İş ilanı ekleme sayfasının çağırılması
    @RequestMapping("/addJobListing")
    public ModelAndView getAddJobListing() {
        return new ModelAndView("addJobListing", "jobListing", new JobListing());
    }

    //form validation işlemleri ve iş ilanı ekleme
    @RequestMapping(value = "/addJobListing", method = RequestMethod.POST)
    public String addJobListing(@Valid @ModelAttribute("jobListing") JobListing j, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "addJobListing";
        jobListingService.addJobListing(j);
        return "redirect:/getJobListings";
    }

    //İş ilanlarını listeleme
    @RequestMapping("/getJobListings")
    public ModelAndView getJobListings() {
        return new ModelAndView("JobListings", "jobListings", jobListingService.getJobListings());
    }

    //Gelen iş ilanının id'sine göre iş ilanını silme
    @RequestMapping(value = "/getJobListings/{id}")
    public String deleteJobListing(@PathVariable Long id) {
        jobListingService.deleteJobListing(id);
        return "redirect:/getJobListings";
    }

    //Gelen iş ilanının id'sine göre iş ilanının detaylarını gösterme
    @RequestMapping("/jobListingDetail/{id}")
    public ModelAndView getJobListingDetail(@PathVariable Long id) {
        return new ModelAndView("jobListingDetail", "jobListingDetail", jobListingService.getJobListingDetail(id));
    }
    //Yapılan başvuruların listelenmesi
    @RequestMapping("/getApplicationList")
    public ModelAndView getApplicationList() {
        return new ModelAndView("applicationList", "jobListings", jobListingService.getJobListings());
    }

    //Başvuru detaylarının gösterilmesi
    @RequestMapping("/getApplicationListDetail/{id}")
    public ModelAndView getApplicationListDetail(@PathVariable Long id) {
        return new ModelAndView("applicationListDetail", "jobListingDetail", jobListingService.getJobListingDetail(id));
    }
}
