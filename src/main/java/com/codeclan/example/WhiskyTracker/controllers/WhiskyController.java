package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(
            @RequestParam(name = "age", required = false) Integer age
    ){
        if(age != null){
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findByAge(age), HttpStatus.OK);
        }return new ResponseEntity<List<Whisky>>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/age/distillery")
    public ResponseEntity<List<Whisky>> getWhiskiesByAgeAndDistilleryName(
            @RequestParam(name = "year") Integer year,
            @RequestParam(name="distilleryName") String distilleryName
    ){
        return new ResponseEntity<List<Whisky>>(whiskyRepository.findByYearAndDistilleryName(year, distilleryName), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/region")
    public ResponseEntity<List<Whisky>> getAllWhiskiesFromRegion(
            @RequestParam(name = "regionName") String regionName
    ){
        return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(regionName), HttpStatus.OK);
    }
}
