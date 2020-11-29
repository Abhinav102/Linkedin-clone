package com.kodem.demo.linkedin.skillsModels.language;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {
    @Autowired
    private LanguageRepository languageRepository;

    public void createCompany(Language language) {
        languageRepository.save(language);
    }

    // Retrieve
    public Language getCompany(String url) {
        return languageRepository.findByUrl(url).get();
    }

    public List<Language> getAllCompanies() {
        return languageRepository.findAll();
    }

    // Update
    public void updateCompany(Language updatedCompany, String url) {
        Language oldCompany = languageRepository.findByUrl(url).get();
        updatedCompany.setId(oldCompany.getId());
        languageRepository.save(updatedCompany);
    }

    // Delete
    public void deleteCompany(String url) {
        Language language = languageRepository.findByUrl(url).get();
        languageRepository.delete(language);
    }
}
