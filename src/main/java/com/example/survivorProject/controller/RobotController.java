package com.example.survivorProject.controller;

import com.example.survivorProject.entity.Robot;
import com.example.survivorProject.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sorted-robots")
public class RobotController {
    @Autowired
    private RobotService robotService;
    @GetMapping
    public ResponseEntity<List<Robot>> getSortedRobots(){
        String url = "https://robotstakeover20210903110417.azurewebsites.net/robotcpu";
        List<Robot> sortedRobots = robotService.getSortedRobotsFromURL(url);
        return ResponseEntity.ok(sortedRobots);
    }
}
