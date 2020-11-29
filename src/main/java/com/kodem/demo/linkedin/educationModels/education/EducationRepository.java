package com.kodem.demo.linkedin.educationModels.education;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Integer>{
    List<Education> findByUserUsername(String username);
}
