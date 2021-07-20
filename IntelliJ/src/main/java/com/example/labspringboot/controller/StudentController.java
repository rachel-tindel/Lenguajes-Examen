package com.example.labspringboot.controller;

import com.example.labspringboot.domain.Student;
import com.example.labspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = "/api/student")
public class StudentController { //Se manejan las reglas de negocio

    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public List<Student> list() {
        return service.listAll();
    }

    @GetMapping("/students/{id}") //route
    public ResponseEntity<Student> get(@PathVariable Integer id) {
        try {
            Student student = service.get(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public void add(@RequestBody Student student) {
        //reglas de negocio??
        service.save(student);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable Integer id) {
        try {
            service.save(student);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


/*---------------------------------------------------------------------SP----------------------------------------------------------------------*/

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }
    @GetMapping("/getStudent/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
        try {
            Student student = service.getStudentById(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/saveStudent")
    public ResponseEntity<?> insertStudent(@RequestBody Student student) {
        service.insertStudentSP(student);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PostMapping("/updateStudent")
    public void updateStudent(@RequestBody Student student){
        service.updateStudentSP(student);
    }
    @DeleteMapping("/deleteSP/{id}")
    public void deleteSP(@PathVariable int id) {
        service.deleteStudentSP(id);
    }
}