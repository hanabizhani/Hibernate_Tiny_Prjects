package com.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "person")
@Inheritance(strategy= InheritanceType.JOINED)
public class Person {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Timestamp lastUpdate;
    private byte[] picture;
    private byte activeNow;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }


    public byte isActiveNow() {
        return activeNow;
    }

    public void setActiveNow(byte activeNow) {
        this.activeNow = activeNow;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", picture=" + Arrays.toString(picture) +
                '}';
    }
}
