package com.example.labspringboot.controller;

import com.example.labspringboot.domain.Major;
import com.example.labspringboot.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = "/api/major")

public class MajorController {

    @Autowired
    private MajorService service;

    @GetMapping("/getAllMajors")
    public List<Major> getAllMajors() {
        return service.getAllMajors();
    }

    @GetMapping("/getMajor/{id}")
    public ResponseEntity<Major> getMajorById(@PathVariable Integer id){
        try {
            Major major = service.getMajorById(id);
            return new ResponseEntity<Major>(major, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Major>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/saveMajor")
    public ResponseEntity<?> insertMajor(@RequestBody Major major) {
        try{

        service.insertMajorSP(major);
        return new ResponseEntity(HttpStatus.CREATED);

        }catch (NoSuchElementException e){
            return new ResponseEntity<Major>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/updateMajor")
    public ResponseEntity<?> updateMajor(@RequestBody Major major){
        try{
            service.updateMajorSP(major);
            return new ResponseEntity(HttpStatus.CREATED);

        }catch (NoSuchElementException e){
            return new ResponseEntity<Major>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteMajorSP/{id}")
    public ResponseEntity<?> deleteMajorSP(@PathVariable int id) {
        try{
            service.deleteMajorSP(id);
            return new ResponseEntity(HttpStatus.CREATED);

        }catch (NoSuchElementException e){
            return new ResponseEntity<Major>(HttpStatus.NOT_FOUND);
        }
    }
}
