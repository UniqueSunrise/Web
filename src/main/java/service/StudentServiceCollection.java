package service;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ru.prog.Web.model.*;


@Service
public class StudentServiceCollection {
	
	private List<Student> students = new ArrayList<>();
	
	public StudentServiceCollection() {
		students.add(new Student(1, "Renat"));
		students.add(new Student(2, "Radmir"));
		students.add(new Student(3, "Timur"));
	}
	
	public List<Student> getStudents(){
		return students;
	}
	
	public Student getStudent(int id) {
		return students.stream().filter(student -> student.getId() == id).findFirst().orElse(new Student());
	}
	
	public Student addStudent(Student student) {
		students.add(student);
		return student;
	}
	
	public Student editStudent(int id, String name) {
		return students.stream().filter(student -> student.getId() == id).findFirst().map(student -> {
				student.setName(name);
				return student;
		}).orElse(new Student());
			
		}
	public void deleteStudent(int id) {
		students = students.stream().filter(student -> student.getId() != id).collect(Collectors.toList());
	}
}
