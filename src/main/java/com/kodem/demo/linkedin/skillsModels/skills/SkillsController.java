package com.kodem.demo.linkedin.skillsModels.skills;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
public class SkillsController {
    @Autowired
    private SkillsRepository skillsRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public void createSkills(@RequestBody SkillsRequestBody skillsRequestBody) {
        Language language = languageRepository.findByUrl(skillsRequestBody.getLanguage()).get();
        User user = userRepository.findByUsername(skillsRequestBody.getUser()).get();
        Skills skills = new Skills(language,user);
        skillsRepository.save(skills);

    }

    @GetMapping
    public List<Skills> getAllSkills(@RequestParam("user") String username) {
        return skillsRepository.findByUserUsername(username);
    }
    
    @GetMapping("/{id}")
    public Skills getSkill(@PathVariable Integer id) {
        return skillsRepository.findById(id).get();
    }
    
    @PutMapping("/{id}")
    public void updateSkills(@RequestBody SkillsRequestBody skillsRequestBody, @PathVariable Integer id) {
        Language language = languageRepository.findByUrl(skillsRequestBody.getLanguage()).get();
        User user = userRepository.findByUsername(skillsRequestBody.getUser()).get();
        Skills skills = new Skills(language,user);
        skills.setId(id);
        skillsRepository.save(skills);

    }

    @DeleteMapping("/{id}")
    public void deleteSkills(@PathVariable Integer id) {
        skillsRepository.deleteById(id);
    }
}
