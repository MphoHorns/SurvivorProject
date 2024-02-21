package com.example.survivorProject.entity;

import com.example.survivorProject.enumeration.Gender;
import jakarta.persistence.*;
@Entity
@Table
public class Survivor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    int age;
    private float latitude;
    private float longitude;

    private int InfectionCounter;
    private boolean infected;
    @Embedded
    private Inventory inventories;

    public Inventory getInventories() {
        return inventories;
    }

    public void setInventories(Inventory inventories) {
        this.inventories = inventories;
    }
    public Survivor() {
    }

    public Survivor(String name, Gender gender,int age, float latitude, float longitude) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "survivor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public int getInfectionCounter() {
        return InfectionCounter;
    }

    public void setInfectionCounter(int infectionCounter) {
        InfectionCounter = infectionCounter;
    }

    public boolean isInfected(boolean b) {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }
}
