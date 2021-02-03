package com.kodem.demo.linkedin.educationModels.education;

public class EducationRequestBody {
    private String course;
    private String college;
    private String duration;
    private String startMonth;
    private String endMonth;
    private String description;
    private String location;
    private String user;

    public EducationRequestBody(String course, String college, String duration, String startMonth, String endMonth,
            String description, String location, String user) {
        this.course = course;
        this.college = college;
        this.duration = duration;
        this.startMonth = startMonth;
        this.endMonth = endMonth;
        this.description = description;
        this.location = location;
        this.user = user;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
