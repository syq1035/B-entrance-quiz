package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.entity.Group;
import com.thoughtworks.capability.gtb.entrancequiz.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students;
    private List<Group> groups;
    private Integer GROUP_SIZE = 6;

    public StudentService() {
        students = new ArrayList<>();
        groups = new ArrayList<>();
        initStudents();
    }

    public void initStudents() {
        students.add(new Student(1, "成吉思汗"));
        students.add(new Student(2, "鲁班七号"));
        students.add(new Student(3, "太乙真人"));
        students.add(new Student(4, "钟无艳"));
        students.add(new Student(5, "花木兰"));
        students.add(new Student(6, "雅典娜"));
        students.add(new Student(7, "芈月"));
        students.add(new Student(8, "白起"));
        students.add(new Student(9, "刘禅"));
        students.add(new Student(10, "庄周"));
        students.add(new Student(11, "马超"));
        students.add(new Student(12, "刘备"));
        students.add(new Student(13, "哪吒"));
        students.add(new Student(14, "大乔"));
        students.add(new Student(15, "蔡文姬"));
    }

    public void initGroups() {
        groups.clear();
        for (int i = 0; i < this.GROUP_SIZE; i ++){
            groups.add(new Group((i + 1) + " 组"));
        }
    }


    public List<Student> getAllStudents() {
        return this.students;
    }

    public void add(Student student) {
        student.setId(students.size() + 1);
        students.add(student);
    }

    public List<Group> grouping() {
        initGroups();
        ArrayList<Student> studentArrayList = new ArrayList<>(this.students);
        Collections.shuffle(studentArrayList);
        int flag = 0;
        for(Student student: studentArrayList) {
            groups.get(flag).add(student);
            flag ++;
            flag = flag >= this.GROUP_SIZE ? 0 : flag;
        }
        return this.groups;
    }
}
