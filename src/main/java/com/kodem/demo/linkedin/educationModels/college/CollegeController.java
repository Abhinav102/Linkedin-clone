package com.kodem.demo.linkedin.educationModels.college;

import java.util.List;

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
@RequestMapping("/college")

public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @PostMapping
    public void createCollege(@RequestBody College College) {
        collegeService.createCollege(College);
    }

    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    @PutMapping("/{url}")
    public void updateCollege(@RequestBody College College, @PathVariable String url) {
        collegeService.updateCollege(College, url);
    }

    @DeleteMapping("/{url}")
    public void deleteCollege(@PathVariable String url) {
        collegeService.deleteCollege(url);
    }
}
