package com.kodem.demo.linkedin.skillsModels.skills;

public class SkillsRequestBody {
    private String id;
    private String user;
    private String language;

    public SkillsRequestBody(String user, String language) {
        this.user = user;
        this.language = language;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
