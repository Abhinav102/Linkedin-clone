package com.kodem.demo.linkedin.skillsModels.language;

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
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @PostMapping
    public void createCompany(@RequestBody Language language) {
        languageService.createCompany(language);
    }

    @GetMapping
    public List<Language> getAllCompanies() {
        return languageService.getAllCompanies();
    }

    @PutMapping("/{url}")
    public void updateCompany(@RequestBody Language language, @PathVariable String url) {
        languageService.updateCompany(language, url);
    }

    @DeleteMapping("/{url}")
    public void deleteCompany(@PathVariable String url) {
        languageService.deleteCompany(url);
    }
}
