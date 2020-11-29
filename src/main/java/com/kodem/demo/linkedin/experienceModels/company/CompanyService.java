package com.kodem.demo.linkedin.experienceModels.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    // Retrieve
    public Company getCompany(String url) {
        return companyRepository.findByUrl(url).get();
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // Update
    public void updateCompany(Company updatedCompany, String url) {
        Company oldCompany = companyRepository.findByUrl(url).get();
        updatedCompany.setId(oldCompany.getId());
        companyRepository.save(updatedCompany);
    }

    // Delete
    public void deleteCompany(String url) {
        Company company = companyRepository.findByUrl(url).get();
        companyRepository.delete(company);
    }
}
