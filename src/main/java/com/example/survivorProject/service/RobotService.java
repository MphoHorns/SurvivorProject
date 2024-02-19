package com.example.survivorProject.service;

import com.example.survivorProject.entity.Robot;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class RobotService {
    public List<Robot> getSortedRobotsFromURL(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Robot[]> responseEntity = restTemplate.getForEntity(url, Robot[].class);
        Robot[] robot = responseEntity.getBody();
        Arrays.sort(robot, Comparator.comparing(Robot::getCategory));
        return Arrays.asList(robot);
    }
}
