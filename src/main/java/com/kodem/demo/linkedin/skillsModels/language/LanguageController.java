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
    public void createLanguage(@RequestBody Language language) {
        languageService.createLanguage(language);
    }

    @GetMapping
    public List<Language> getAllLanguages() {
        return languageService.getAllLanguages();
    }

    @PutMapping("/{url}")
    public void updateLanguage(@RequestBody Language language, @PathVariable String url) {
        languageService.updateLanguage(language, url);
    }

    @DeleteMapping("/{url}")
    public void deleteLanguage(@PathVariable String url) {
        languageService.deleteLanguage(url);
    }
}
