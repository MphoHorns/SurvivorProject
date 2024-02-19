package com.example.survivorProject.exceptions;

public class SurvivorNotFoundException extends RuntimeException{
    public SurvivorNotFoundException(String message){
        super(message);
    }
}
