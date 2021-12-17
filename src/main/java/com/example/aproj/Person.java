package com.example.aproj;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
    @Id
    public int personId;

    public String name;
    public String surname;



    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
