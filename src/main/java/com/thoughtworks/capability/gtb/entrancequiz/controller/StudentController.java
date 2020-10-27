package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.entity.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping("/student")
    public ResponseEntity addStudent(@RequestBody Student student) {
        studentService.add(student);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/groups")
    public ResponseEntity<ArrayList<ArrayList<Student>>> groupStudents() {
        return ResponseEntity.ok(studentService.groups());
    }
}
