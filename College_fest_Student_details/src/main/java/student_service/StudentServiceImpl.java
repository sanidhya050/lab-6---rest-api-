package student_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import student_Repository.StudentRepository;
import student_entity.Student;

public class StudentServiceImpl  implements StudentService{
	
	@Autowired
	private StudentRepository StudentRepository;

	@Override
	public List<Student> FindAll() {
		
		 return StudentRepository.findAll();
	}

	@Override
	public void save(Student theStudent) {
		 StudentRepository.save(theStudent);
		
	}


	@Override
	public Student findById( long theId) {
		Student Student = StudentRepository.findById(theId).get();
	}	


	@Override
	public void DeleteById(long theId) {
		StudentRepository.deleteById(theId);
		
	}
	

	
	

}
