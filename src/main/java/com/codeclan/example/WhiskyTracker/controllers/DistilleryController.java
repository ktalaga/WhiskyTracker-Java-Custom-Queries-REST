package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "distilleries")
    public ResponseEntity<List<Distillery>> findAllDistilleries(){
        return new ResponseEntity<List<Distillery>>(distilleryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/region")
    public ResponseEntity<List<Distillery>> findDistilleriesByRegion(
            @RequestParam String region
    ){
        return new ResponseEntity<List<Distillery>>(distilleryRepository.findByRegion(region), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/whisky/age")
    public ResponseEntity<List<Distillery>> findDistilleriesByWhiskyAge(
            @RequestParam(name = "whiskyAge") int whiskyAge
    ){
        return new ResponseEntity<>(distilleryRepository.findByWhiskiesYear(whiskyAge), HttpStatus.OK);
    }

}
