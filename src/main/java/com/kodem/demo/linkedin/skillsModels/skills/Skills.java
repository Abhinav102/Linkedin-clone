package com.kodem.demo.linkedin.skillsModels.skills;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.kodem.demo.linkedin.skillsModels.language.Language;
import com.kodem.demo.linkedin.userModel.User;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically Generates a value
    private Integer id;

    @ManyToOne
    private Language language;

    @ManyToOne
    private User user;

    public Skills(Language language, User user) {
        this.language = language;
        this.user = user;
    }

    public Skills() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
