package com.model;

import javax.persistence.Entity;
import java.sql.Timestamp;

@Entity(name = "staff")
public class Staff extends Person{

    private String username;
    private String password;
    private Timestamp hireDate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getHireDate() {
        return hireDate;
    }

    public void setHireDate(Timestamp hireDate) {
        this.hireDate = hireDate;
    }
}
