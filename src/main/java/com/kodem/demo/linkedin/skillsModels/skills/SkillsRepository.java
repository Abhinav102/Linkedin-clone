package com.kodem.demo.linkedin.skillsModels.skills;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository extends JpaRepository<Skills,Integer>{
    List<Skills> findByUserUsername(String username);
}
