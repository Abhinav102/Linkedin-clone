package com.kodem.demo.linkedin.educationModels.college;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/college")

public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @PostMapping
    public void createCompany(@RequestBody College College) {
        collegeService.createCompany(College);
    }

    @GetMapping
    public List<College> getAllCompanies() {
        return collegeService.getAllCompanies();
    }

    @PutMapping("/{url}")
    public void updateCompany(@RequestBody College College, @PathVariable String url) {
        collegeService.updateCompany(College, url);
    }

    @DeleteMapping("/{url}")
    public void deleteCompany(@PathVariable String url) {
        collegeService.deleteCompany(url);
    }
}
