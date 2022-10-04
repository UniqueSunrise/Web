package ru.usatu.students.service;

import ru.usatu.students.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class StudentServiceCollection implements StudentService {
    private List<Student> students = new ArrayList<>();
    public StudentServiceCollection() {
        students.add(new Student(1,"Radmir"));
        students.add(new Student(2,"Timur"));
        students.add(new Student(3,"Renat"));
    }

    public List<Student> getStudents() {
        return students;
    }
    public Student getStudent(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst()
                .orElse(new Student());
    }
    public Student addStudent(Student student){
        students.add(student);
        return student;
    }
    public Student editStudent(int id, String name){
        return students.stream().filter(student -> student.getId() == id).findFirst()
                .map(student -> {
                    student.setName(name);
                    return student;
                }).orElse(new Student());
    }
    public void deleteStudent(int id){
        students = students.stream().filter(student -> student.getId() != id)
                .collect(Collectors.toList());
    }
}
