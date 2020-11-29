package com.kodem.demo.linkedin.skillsModels.language;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language,Integer>{
    Optional<Language> findByUrl(String url);
}
