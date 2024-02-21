package com.example.survivorProject.service;

import com.example.survivorProject.entity.Robot;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RobotService {
            RestTemplate restTemplate = new RestTemplate();

    public List<List<Robot>> getLandRobots(String url) {
          ResponseEntity<Robot[]> responseEntity = restTemplate.getForEntity(url, Robot[].class);
          Robot[] robots = responseEntity.getBody();

          if(robots ==null || robots.length ==0){
             return new ArrayList<>();
           }

           Arrays.sort(robots, Comparator.comparing(Robot::getCategory));
        List<Robot> landRobots = Arrays.stream(robots)
                .filter(robot -> robot.getCategory().equalsIgnoreCase("land"))
                .collect(Collectors.toList());
        List<List<Robot>> sortedRobots = new ArrayList<>();
        sortedRobots.add(landRobots);
        return sortedRobots;
    }

    public List<List<Robot>> getFlyingRobots(String url) {
        ResponseEntity<Robot[]> responseEntity = restTemplate.getForEntity(url, Robot[].class);
        Robot[] robots = responseEntity.getBody();

        if(robots ==null || robots.length ==0){
            return new ArrayList<>();
        }
        Arrays.sort(robots, Comparator.comparing(Robot::getCategory));
        List<Robot> landRobots = Arrays.stream(robots)
                .filter(robot -> robot.getCategory().equalsIgnoreCase("flying"))
                .collect(Collectors.toList());
        List<List<Robot>> sortedRobots = new ArrayList<>();
        sortedRobots.add(landRobots);
        return sortedRobots;
    }

    public List<Robot> getAllRobots(String url) {
        ResponseEntity<Robot[]> responseEntity = restTemplate.getForEntity(url, Robot[].class);
        Robot[] robots = responseEntity.getBody();
        return Arrays.asList(robots);
    }

}
