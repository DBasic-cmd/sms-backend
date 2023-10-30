package com.example.smsbackend.controller;

import com.example.smsbackend.entity.Student;
import com.example.smsbackend.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentRepository studentRepository;

    //POST student REST API
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    //GET an individual student REST API
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow();
    }



    //  GET all students REST API
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //UPDATE student REST API
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    //DELETE student REST API
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }


}
