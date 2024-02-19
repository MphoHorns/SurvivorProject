package com.example.survivorProject.entity;

public class Robot {
    private String model;
    private String category;

    public Robot() {
    }

    public Robot(String model, String category) {
        this.model = model;
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "model='" + model + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
