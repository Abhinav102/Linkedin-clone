package com.kodem.demo.linkedin.educationModels.college;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Integer id;
    @Column(unique = true)
    private String Url;
    private String name;
    private String rating;

    public College(String url, String name, String rating) {
        Url = url;
        this.name = name;
        this.rating = rating;
     
    }
    public College(){
        
    }
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}   
}
