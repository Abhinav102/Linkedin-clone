package com.kodem.demo.linkedin.experienceModels.experience;

import java.util.List;

import com.kodem.demo.linkedin.experienceModels.company.Company;
import com.kodem.demo.linkedin.experienceModels.company.CompanyRepository;
import com.kodem.demo.linkedin.userModel.User;
import com.kodem.demo.linkedin.userModel.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experience")
public class ExperienceController {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public void createExperience(@RequestBody ExperienceRequestBody experienceRequestBody) {
        Company company = companyRepository.findByUrl(experienceRequestBody.getCompany()).get();
        User user = userRepository.findByUsername(experienceRequestBody.getUser()).get();
        Experience experience = new Experience(experienceRequestBody.getRole(), company,
                experienceRequestBody.getDuration(), experienceRequestBody.getStartMonth(),
                experienceRequestBody.getEndMonth(), experienceRequestBody.getDescription(),
                experienceRequestBody.getLocation(), user);
        experienceRepository.save(experience);

    }

    @GetMapping
    public List<Experience> getAllExperience(@RequestParam("user") String username) {
        return experienceRepository.findByUserUsername(username);
    }

    @GetMapping("/{id}")
    public Experience getExperience(@PathVariable Integer id) {
        return experienceRepository.findById(id).get();
    }

    @PutMapping("/{id}")
    public void updateExperience(@RequestBody ExperienceRequestBody experienceRequestBody, @PathVariable Integer id) {
        Company company = companyRepository.findByUrl(experienceRequestBody.getCompany()).get();
        User user = userRepository.findByUsername(experienceRequestBody.getUser()).get();
        Experience experience = new Experience(experienceRequestBody.getRole(), company,
                experienceRequestBody.getDuration(), experienceRequestBody.getStartMonth(),
                experienceRequestBody.getEndMonth(), experienceRequestBody.getDescription(),
                experienceRequestBody.getLocation(), user);
        experience.setId(id);
        experienceRepository.save(experience);

    }

    @DeleteMapping("/{id}")
    public void deleteExperience(@PathVariable Integer id) {
        experienceRepository.deleteById(id);
    }
}
