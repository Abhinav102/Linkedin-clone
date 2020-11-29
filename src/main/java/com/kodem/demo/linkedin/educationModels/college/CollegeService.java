package com.kodem.demo.linkedin.educationModels.college;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {
    @Autowired
    private CollegeRepository CollegeRepository;

    public void createCompany(College college) {
        CollegeRepository.save(college);
    }

    // Retrieve
    public College getCompany(String url) {
        return CollegeRepository.findByUrl(url).get();
    }

    public List<College> getAllCompanies() {
        return CollegeRepository.findAll();
    }

    // Update
    public void updateCompany(College updatedCompany, String url) {
        College oldCompany = CollegeRepository.findByUrl(url).get();
        updatedCompany.setId(oldCompany.getId());
        CollegeRepository.save(updatedCompany);
    }

    // Delete
    public void deleteCompany(String url) {
        College college = CollegeRepository.findByUrl(url).get();
        CollegeRepository.delete(college);
    }
}
