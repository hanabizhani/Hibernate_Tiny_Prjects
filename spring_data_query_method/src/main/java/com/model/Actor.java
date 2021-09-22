package com.model;

import javax.persistence.Entity;

@Entity(name = "actor")
public class Actor extends Person{

    private String skills;

    public String getYearsActive() {
        return skills;
    }

    public void setYearsActive(String skills) {
        this.skills = skills;
    }

}
