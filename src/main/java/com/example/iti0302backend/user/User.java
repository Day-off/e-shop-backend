package com.example.iti0302backend.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;

@Entity
@Table(name = "users", schema = "public")
public class User {

    @Id
    private Integer user_id;
    private String firstName;
    private String secondName;
    private Time contact;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Time getContact() {
        return contact;
    }

    public void setContact(Time registration_time) {
        this.contact = registration_time;
    }
}
