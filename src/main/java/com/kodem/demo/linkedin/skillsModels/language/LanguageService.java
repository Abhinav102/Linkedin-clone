package com.kodem.demo.linkedin.skillsModels.language;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {
    @Autowired
    private LanguageRepository languageRepository;

    public void createLanguage(Language language) {
        languageRepository.save(language);
    }

    // Retrieve
    public Language getLanguage(String url) {
        return languageRepository.findByUrl(url).get();
    }

    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    // Update
    public void updateLanguage(Language updatedLanguage, String url) {
        Language oldLanguage = languageRepository.findByUrl(url).get();
        updatedLanguage.setId(oldLanguage.getId());
        languageRepository.save(updatedLanguage);
    }

    // Delete
    public void deleteLanguage(String url) {
        Language language = languageRepository.findByUrl(url).get();
        languageRepository.delete(language);
    }
}
