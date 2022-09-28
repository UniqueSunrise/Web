package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



import ru.prog.Web.model.Student;
import service.StudentServiceCollection;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	private StudentServiceCollection studentService;
	
	public StudentController(StudentServiceCollection studentService) {
		this.studentService = studentService;
	}
	
	 @GetMapping
	    public @ResponseBody
	    List<Student> getStudents() throws Exception {
	        return studentService.getStudents(); }
	    @GetMapping("/{id}")
	    public @ResponseBody
	    Student getStudent(@PathVariable int id) {return studentService.getStudent(id);}

	    @PostMapping
	    public @ResponseBody
	    Student addStudent(@RequestBody Student student) {return studentService.addStudent(student);}

	    @PutMapping("/{id}")
	    public @ResponseBody
	    Student editStudent(@PathVariable int id, @RequestBody String name) {return studentService.editStudent(id,name);}

	    @DeleteMapping("/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public void deleteStudent(@PathVariable int id) { studentService.deleteStudent(id);}
	}