package com.kodem.demo.linkedin.experienceModels.experience;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    List<Experience> findByUserUsername(String username);
}
