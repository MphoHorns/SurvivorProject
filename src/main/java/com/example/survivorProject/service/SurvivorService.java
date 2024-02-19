package com.example.survivorProject.service;

import com.example.survivorProject.entity.Inventory;
import com.example.survivorProject.entity.Survivor;
import com.example.survivorProject.exceptions.SurvivorNotFoundException;
import com.example.survivorProject.repository.SurvivorRepository;
import com.example.survivorProject.request.SurvivorUpdateRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurvivorService {
    private final SurvivorRepository survivorRepository;

    public SurvivorService(SurvivorRepository survivorRepository) {
        this.survivorRepository = survivorRepository;
    }

    public List<Survivor> getAllSurvivors() {
        return survivorRepository.findAll();
    }

    public Survivor addSurvivorWithInventory(Survivor survivor) {
        List<Inventory> inventories = survivor.getInventories();
        for(Inventory inventory : inventories){
            inventory.setSurvivor(survivor);
        }
        Survivor savedSurvivor = survivorRepository.save(survivor);

        return savedSurvivor;
    }

    public String updateSurvivorLocation(long survivorId, float latitude, float longitude) {
        Survivor survivor = survivorRepository.findById(survivorId).orElseThrow(()->
                new SurvivorNotFoundException("Survivor not found."));
        survivor.setLatitude(latitude);
        survivor.setLongitude(longitude);
        survivorRepository.save(survivor);
        return "Survivor's location updated successfully.";

    }

    public void reportInfection(long survivorId) {
//        Survivor survivor = survivorRepository.findById(survivorId).orElseThrow(()->
//                new SurvivorNotFoundException("Survivor not found."));
//        survivor.isInfected(true);
//        survivorRepository.save(survivor);

        Optional<Survivor> survivorOptional = survivorRepository.findById(survivorId);
            if(survivorOptional.isPresent()){
                Survivor survivor = survivorOptional.get();
                int currentInfectionCounter = survivor.getInfectionCounter();
                survivor.setInfectionCounter(currentInfectionCounter +1);
                  if(survivor.getInfectionCounter() >=3){
                        survivor.setInfected(true);
                  }
                  survivorRepository.save(survivor);

            }
            else{
                throw  new EntityNotFoundException("Survivor with Id "+ survivorId +" not found.");
            }

    }

    public List<Survivor> getInfectedSurvivors(boolean infected) {
        List<Survivor> survivor = survivorRepository.findByInfected(infected);
        return survivor;
    }

    public double getInfectedPercentageSurvivors() {
        long totalSurvivors = survivorRepository.count();
        long infectedSurvivors = survivorRepository.countByInfected(true);
        double totalPercentage = (double) infectedSurvivors / totalSurvivors * 100;

        double roundedPercentage = Math.round(totalPercentage *100.0)/ 100.0;
        return roundedPercentage;
    }

    public double getPercentageDisinfectedSurvivor() {
        return 100 - getInfectedPercentageSurvivors();
    }
}



