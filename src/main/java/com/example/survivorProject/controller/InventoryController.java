package com.example.survivorProject.controller;

import com.example.survivorProject.entity.Inventory;
import com.example.survivorProject.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Inventory")
public class InventoryController {
    private final InventoryService inventoryService;
    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    @PostMapping
    public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory){
        Inventory newInventory = inventoryService.addInventory(inventory);
        return  new ResponseEntity<>(newInventory, HttpStatus.CREATED);
    }
}
