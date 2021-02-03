package com.kodem.demo.linkedin.educationModels.college;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {
    @Autowired
    private CollegeRepository collegeRepository;

    public void createCompany(College college) {
        collegeRepository.save(college);
    }

    // Retrieve
    public College getCompany(String url) {
        return collegeRepository.findByUrl(url).get();
    }

    public List<College> getAllCompanies() {
        return collegeRepository.findAll();
    }

    // Update
    public void updateCompany(College updatedCompany, String url) {
        College oldCompany = collegeRepository.findByUrl(url).get();
        updatedCompany.setId(oldCompany.getId());
        collegeRepository.save(updatedCompany);
    }

    // Delete
    public void deleteCompany(String url) {
        College college = collegeRepository.findByUrl(url).get();
        collegeRepository.delete(college);
    }
}
