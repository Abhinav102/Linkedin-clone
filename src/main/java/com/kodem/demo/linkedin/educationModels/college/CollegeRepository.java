package com.kodem.demo.linkedin.educationModels.college;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College,Integer>{
    Optional<College> findByUrl(String url);   
}
