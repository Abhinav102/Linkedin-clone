package com.kodem.demo.linkedin.experienceModels.company;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Optional<Company> findByUrl(String url);
}
