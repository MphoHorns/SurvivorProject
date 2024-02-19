package com.example.survivorProject.service;

import com.example.survivorProject.entity.Inventory;
import com.example.survivorProject.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    @Autowired

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory addInventory(Inventory inventory) {
            Inventory savedInventory = inventoryRepository.save(inventory);
            return savedInventory;
    }
}
