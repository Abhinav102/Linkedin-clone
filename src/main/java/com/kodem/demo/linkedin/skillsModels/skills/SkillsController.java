package com.kodem.demo.linkedin.skillsModels.skills;

import java.util.List;

import javax.websocket.server.PathParam;

import com.kodem.demo.linkedin.skillsModels.language.Language;
import com.kodem.demo.linkedin.skillsModels.language.LanguageRepository;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
public class SkillsController {
    @Autowired
    private SkillsRepository experienceRepository;

    @Autowired
    private LanguageRepository LanguageRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public void createExperience(@RequestBody SkillsRequestBody experienceRequestBody) {
        Language language = LanguageRepository.findByUrl(experienceRequestBody.getLanguage()).get();
        User user = userRepository.findByUsername(experienceRequestBody.getUser()).get();
        Skills skills = new Skills(language,user);
        experienceRepository.save(skills);

    }

    @GetMapping
    public List<Skills> getAllExperience(@PathParam("user") String username) {
        return experienceRepository.findByUserUsername(username);
    }

    @PutMapping("/{id}")
    public void updateExperience(@RequestBody SkillsRequestBody experienceRequestBody, @PathVariable Integer id) {
        Language language = LanguageRepository.findByUrl(experienceRequestBody.getLanguage()).get();
        User user = userRepository.findByUsername(experienceRequestBody.getUser()).get();
        Skills skills = new Skills(language,user);
        skills.setId(id);
        experienceRepository.save(skills);

    }

    @DeleteMapping("/{id}")
    public void deleteExperience(@PathVariable Integer id) {
        experienceRepository.deleteById(id);
    }
}
