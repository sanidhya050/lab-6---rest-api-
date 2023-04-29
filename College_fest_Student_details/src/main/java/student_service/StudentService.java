package student_service;

import java.util.List;

import org.springframework.stereotype.Service;

import student_entity.Student;

@Service
public interface StudentService {

	// view all books 
	public List<Student> FindAll();
	
	public Student findById(long id);
	
	
	
	// Insert or update the data 
	public void save(Student theStudent);
	
	
	
	// deleteById 
	public void DeleteById(long id);
	
	



	
}
