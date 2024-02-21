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
@RequestMapping("/robots")
public class RobotController {
    @Autowired
    private RobotService robotService;
    String url = "https://robotstakeover20210903110417.azurewebsites.net/robotcpu";
    @GetMapping("/allrobots")
    public ResponseEntity<List<Robot>> getAllRobots(){

        List<Robot> allRobots = robotService.getAllRobots(url);
        return ResponseEntity.ok(allRobots);
    }
    @GetMapping("/landrobots")
    public ResponseEntity<List<List<Robot>>> getLandRobots(){
        List<List<Robot>> landRobots = robotService.getLandRobots(url);
        return ResponseEntity.ok(landRobots);
    }
    @GetMapping("/flyingrobots")
    public ResponseEntity<List<List<Robot>>> getFlyingRobots(){
        List<List<Robot>> flyingRobots =robotService.getFlyingRobots(url);
        return ResponseEntity.ok(flyingRobots);
    }
}
