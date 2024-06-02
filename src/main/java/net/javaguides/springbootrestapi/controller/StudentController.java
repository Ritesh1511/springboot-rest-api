package net.javaguides.springbootrestapi.controller;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springbootrestapi.controller.bean.Student;

@RestController
public class StudentController {
 //returning jason
	@GetMapping("/student")
	public Student getStudent() {
		
		Student student = new Student(
				1,"Ramesh","Fadatre"
			);
			
		return student;
	}
	//returning list	
	@GetMapping("/students")
	public List<Student> getStudents() {
		List <Student> students = new ArrayList<>();
		students.add(new Student(1,"ms","dhone"));
		students.add(new Student(1,"virat","kohli"));
		
		return students;
	}
//-------------------------------------------------------------------------------//pathvariable
	//path variable
	@GetMapping("/students/{id}/{first-name}/{last-name}") 
	//http://localhost:8080/students/22/ramesh/fadatre
	public Student studentpathvariable( @PathVariable("id") int studentId 
										,@PathVariable("first-name") String first_name
										,@PathVariable("last-name") String last_name
										) {
		return (new Student(studentId,first_name,last_name)); 
	}
//-------------------------------------------------------------------------------//requestparam
	//request param
	@GetMapping("/students/query") 
	// http://localhost:8080/students/query?id=22&firstname=ramesh&lastname=fadatre
	public Student studentrequestparametre( @RequestParam  int id
			,@RequestParam String firstname
			,@RequestParam String lastname
			) {
return (new Student(id,firstname,lastname)); 
}
//-------------------------------------------------------------------------------//requestbody
	//request body
	@PostMapping("/students/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student studentcreate(@RequestBody Student student_object)
	{	
		System.out.println(student_object.getId());
		System.out.println(student_object.getFirstname());
		System.out.println(student_object.getLastname());
		
		return student_object;
	}

	//-------------------------------------------------------------------------------//put
		//request body
		@PutMapping("/students/{id}/update")
		@ResponseStatus(HttpStatus.CREATED)
		public Student updatestudent(@RequestBody Student student_object, @PathVariable("id") int id)
		{	
			System.out.println(student_object.getId());
			System.out.println(student_object.getFirstname());
			System.out.println(student_object.getLastname());
			
			return student_object;
		}
	//-------------------------------------------------------------------------------//delete	
		@DeleteMapping ("students/{id}/delete")
		public String deleteStudent(@PathVariable("id") int studentId){
		System.out.println(studentId);
		return "Student deleted successfully!";
		}
		
     //response entity
		@GetMapping("/student/rs")
		public ResponseEntity<Student> getStudent1() {
			
			Student student = new Student(
					1,"Ramesh","Fadatre"
				);
				
			//return new ResponseEntity<>(student , HttpStatus.OK);
			return ResponseEntity.ok(student);
   }
		
}		
