package com.kodem.demo.linkedin.educationModels.college;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {
    @Autowired
    private CollegeRepository collegeRepository;

    public void createCollege(College college) {
        collegeRepository.save(college);
    }

    // Retrieve
    public College getCollege(String url) {
        return collegeRepository.findByUrl(url).get();
    }

    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    // Update
    public void updateCollege(College updatedCollege, String url) {
        College oldCollege = collegeRepository.findByUrl(url).get();
        updatedCollege.setId(oldCollege.getId());
        collegeRepository.save(updatedCollege);
    }

    // Delete
    public void deleteCollege(String url) {
        College college = collegeRepository.findByUrl(url).get();
        collegeRepository.delete(college);
    }
}
