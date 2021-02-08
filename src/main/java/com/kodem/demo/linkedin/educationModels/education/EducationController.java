package com.kodem.demo.linkedin.educationModels.education;

import java.util.List;


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
import org.springframework.web.bind.annotation.RequestParam;
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
    public void createEducation(@RequestBody EducationRequestBody educationRequestBody) {
        College college = collegeRepository.findByUrl(educationRequestBody.getCollege()).get();
        User user = userRepository.findByUsername(educationRequestBody.getUser()).get();
        Education education = new Education(educationRequestBody.getCourse(), college,
                educationRequestBody.getDuration(), educationRequestBody.getStartMonth(),
                educationRequestBody.getEndMonth(), educationRequestBody.getDescription(),
                educationRequestBody.getLocation(), user);
        educationRepository.save(education);

    }

    @GetMapping
    public List<Education> getAllEducation(@RequestParam("user") String username) {
        return educationRepository.findByUserUsername(username);
    }


    @GetMapping("/{id}")
    public Education getEducation(@PathVariable Integer id) {
        return educationRepository.findById(id).get();
    }

    @PutMapping("/{id}")
    public void updateEducation(@RequestBody EducationRequestBody educationRequestBody, @PathVariable Integer id) {
        College college = collegeRepository.findByUrl(educationRequestBody.getCollege()).get();
        User user = userRepository.findByUsername(educationRequestBody.getUser()).get();
        Education education = new Education(educationRequestBody.getCourse(), college,
                educationRequestBody.getDuration(), educationRequestBody.getStartMonth(),
                educationRequestBody.getEndMonth(), educationRequestBody.getDescription(),
                educationRequestBody.getLocation(), user);
        education.setId(id);
        educationRepository.save(education);

    }

    @DeleteMapping("/{id}")
    public void deleteEducation(@PathVariable Integer id) {
        educationRepository.deleteById(id);
    }
}
