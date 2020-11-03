package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.entity.Group;
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

    //TODO GTB-知识点: - StudentController.java:27 根据restful实践，资源名一般是复数
    //TODO GTB-知识点: - StudentController.java:28 根据restful实践，POST方法一般返回创建的内容或者Id
    //TODO GTB-知识点: - StudentController.java:29 POST方法返回的状态码，是201
    //TODO GTB-知识点: - StudentController.java:29 如果不是有自定义返回的需求，ResponseEntity一般可省略
    @PostMapping("/student")
    public ResponseEntity addStudent(@RequestBody Student student) {
        studentService.add(student);
        return ResponseEntity.ok().build();
    }
    //TODO GTB-工程实践: - StudentController.java:32 group相关的接口，单独抽取一个controller来做，与students不是操作的一个资源
    //TODO GTB-完成度: - StudentController.java:37 bug，新增学员无法进行分组操作
    @GetMapping("/groups")
    public ResponseEntity<List<Group>> groupingStudents() {
        return ResponseEntity.ok(studentService.grouping());
    }
}
