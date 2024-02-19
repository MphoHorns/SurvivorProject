package com.example.survivorProject.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean hasWater;
    private boolean hasFood;
    private boolean hasMedication;
    private boolean hasAmmunition;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "survivor_id")
    private Survivor survivor;

    public Inventory() {
    }

    public Inventory(boolean hasWater, boolean hasFood, boolean hasMedication, boolean hasAmmunition) {
        this.hasWater = hasWater;
        this.hasFood = hasFood;
        this.hasMedication = hasMedication;
        this.hasAmmunition = hasAmmunition;
    }

    public boolean isHasWater() {
        return hasWater;
    }

    public void setHasWater(boolean hasWater) {
        this.hasWater = hasWater;
    }

    public boolean isHasFood() {
        return hasFood;
    }

    public void setHasFood(boolean hasFood) {
        this.hasFood = hasFood;
    }

    public boolean isHasMedication() {
        return hasMedication;
    }

    public void setHasMedication(boolean hasMedication) {
        this.hasMedication = hasMedication;
    }

    public boolean isHasAmmunition() {
        return hasAmmunition;
    }

    public void setHasAmmunition(boolean hasAmmunition) {
        this.hasAmmunition = hasAmmunition;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "hasWater=" + hasWater +
                ", hasFood=" + hasFood +
                ", hasMedication=" + hasMedication +
                ", hasAmmunition=" + hasAmmunition +
                '}';
    }

    public void setSurvivor(Survivor survivor) {
    }
}
