package com.model;

import javax.persistence.Entity;

@Entity(name = "actor")
public class Actor extends Person{

    private int yearsActive;

    public int getYearsActive() {
        return yearsActive;
    }

    public void setYearsActive(int yearsActive) {
        this.yearsActive = yearsActive;
    }

}
