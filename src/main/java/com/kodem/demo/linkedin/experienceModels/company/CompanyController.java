package com.kodem.demo.linkedin.experienceModels.company;

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
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public void createCompany(@RequestBody Company company) {
        companyService.createCompany(company);
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @PutMapping("/{url}")
    public void updateCompany(@RequestBody Company company, @PathVariable String url) {
        companyService.updateCompany(company, url);
    }

    @DeleteMapping("/{url}")
    public void deleteCompany(@PathVariable String url) {
        companyService.deleteCompany(url);
    }
}
