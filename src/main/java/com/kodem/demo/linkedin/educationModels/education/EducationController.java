package com.kodem.demo.linkedin.educationModels.education;

import java.util.List;

import javax.websocket.server.PathParam;

import com.kodem.demo.linkedin.educationModels.college.College;
import com.kodem.demo.linkedin.educationModels.college.CollegeRepository;
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
@RequestMapping("/education")
public class EducationController {
    
    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public void createEducation(@RequestBody EducationRequestBody experienceRequestBody) {
        College college = collegeRepository.findByUrl(experienceRequestBody.getCompany()).get();
        User user = userRepository.findByUsername(experienceRequestBody.getUser()).get();
        Education education = new Education(experienceRequestBody.getCourse(), college,
                experienceRequestBody.getDuration(), experienceRequestBody.getStartMonth(),
                experienceRequestBody.getEndMonth(), experienceRequestBody.getDescription(),
                experienceRequestBody.getLocation(), user);
        educationRepository.save(education);

    }

    @GetMapping
    public List<Education> getAllExperience(@PathParam("user") String username) {
        return educationRepository.findByUserUsername(username);
    }

    @PutMapping("/{id}")
    public void updateEducation(@RequestBody EducationRequestBody experienceRequestBody, @PathVariable Integer id) {
        College college = collegeRepository.findByUrl(experienceRequestBody.getCompany()).get();
        User user = userRepository.findByUsername(experienceRequestBody.getUser()).get();
        Education education = new Education(experienceRequestBody.getCourse(), college,
                experienceRequestBody.getDuration(), experienceRequestBody.getStartMonth(),
                experienceRequestBody.getEndMonth(), experienceRequestBody.getDescription(),
                experienceRequestBody.getLocation(), user);
        education.setId(id);
        educationRepository.save(education);

    }

    @DeleteMapping("/{id}")
    public void deleteEducation(@PathVariable Integer id) {
        educationRepository.deleteById(id);
    }
}
