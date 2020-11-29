package com.kodem.demo.linkedin.educationModels.education;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.kodem.demo.linkedin.educationModels.college.College;
import com.kodem.demo.linkedin.userModel.User;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically Generates a value
    private Integer id;
    private String role;

    @ManyToOne // Many to One Relationship with Company
    private College college;

    private String duration;
    private String startMonth;
    private String endMonth;
    private String description;
    private String location;

    @ManyToOne // Many to One Relationship with User
    private User user;

    public Education(String role, College college, String duration, String startMonth, String endMonth,
            String description, String location, User user) {
        this.role = role;
        this.college = college;
        this.duration = duration;
        this.startMonth = startMonth;
        this.endMonth = endMonth;
        this.description = description;
        this.location = location;
        this.user = user;
    }

    public Education() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
