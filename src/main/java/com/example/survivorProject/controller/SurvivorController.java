package com.example.survivorProject.controller;

import com.example.survivorProject.entity.Survivor;
import com.example.survivorProject.exceptions.SurvivorNotFoundException;
import com.example.survivorProject.request.SurvivorUpdateRequest;
import com.example.survivorProject.service.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/survivors")
public class SurvivorController {
    private final SurvivorService survivorService;
    @Autowired
    public SurvivorController(SurvivorService survivorService) {
        this.survivorService = survivorService;
    }
    @PostMapping("/add-new-survivor")
    public ResponseEntity<Survivor> addSurvivorWithInventory(@RequestBody Survivor survivor){
        Survivor newSurvivor = survivorService.addSurvivorWithInventory(survivor);
        return new ResponseEntity<>(newSurvivor, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Survivor>> getAllSurvivors(){
        List<Survivor> survivors = survivorService.getAllSurvivors();
        return new ResponseEntity<>(survivors, HttpStatus.OK);
    }
    @GetMapping("/{survivorId}")
    public ResponseEntity<Survivor> getSurvivorById(@PathVariable Long survivorId){
        Optional<Survivor> survivor = survivorService.getSurvivorById(survivorId);
         if(survivor.isPresent()){
             return  new ResponseEntity<>(survivor.get(), HttpStatus.OK);
         }
         else {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }
    @PatchMapping("/{survivorId}")
    public ResponseEntity<String> updateSurvivorLocation(@PathVariable long survivorId, @RequestBody SurvivorUpdateRequest survivorUpdateRequest){
        try{
            String updatedSurvivorLocation = survivorService.updateSurvivorLocation(survivorId,
                    survivorUpdateRequest.getLatitude(),
                    survivorUpdateRequest.getLongitude());
            return ResponseEntity.ok(updatedSurvivorLocation);
        }
        catch (SurvivorNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update survivor location.");
        }
    }
    @PutMapping("/{survivorId}/report-infection")
    public ResponseEntity<String> reportInfection(@PathVariable long survivorId){
        survivorService.reportInfection(survivorId);
        return ResponseEntity.ok("Survivor infection reported successfully.");
    }
    @GetMapping("/infected")
    public ResponseEntity<List<Survivor>> getInfectedSurvivors(){
        List<Survivor> infectedSurvivors = survivorService.getInfectedSurvivors(true);
        return ResponseEntity.ok(infectedSurvivors);
    }
    @GetMapping("/disinfected")
    public  ResponseEntity<List<Survivor>> getDisinfectedSurvivors(){
        List<Survivor> disinfectedSurvivors = survivorService.getInfectedSurvivors(false);
        return ResponseEntity.ok(disinfectedSurvivors);
    }
    @GetMapping("/infected-percentage")
    public ResponseEntity<Double> getPercentageInfectedSurvivors(){
        double infectedPercentage = survivorService.getInfectedPercentageSurvivors();
        return ResponseEntity.ok(infectedPercentage);
    }
    @GetMapping("/disinfected-percentage")
    public ResponseEntity<Double> getPercentageDisinfectedSurvivors(){
        double disinfectedPercentage = survivorService.getPercentageDisinfectedSurvivor();
        return ResponseEntity.ok(disinfectedPercentage);
    }
}
