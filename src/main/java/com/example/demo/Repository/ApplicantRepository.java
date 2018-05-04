package com.example.demo.Repository;

import com.example.demo.Model.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository  extends CrudRepository<Applicant,Long> {
}
