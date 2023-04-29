package student_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import student_Repository.StudentRepository;
import student_entity.Student;

public class StudentServiceImpl  implements StudentService{
	
	@Autowired
	private StudentRepository bookRepository;

	@Override
	public List<Student> FindAll() {
		 return bookRepository.findAll();
	}

	@Override
	public void save(Student theBook) {
		 bookRepository.save(theBook);
		
	}

	@Override
	public void DeleteById(int id) {
		bookRepository.deleteById(id);
		
	}

	@Override
	public Student findById(int id) {
		Student book = bookRepository.findById(id).get();
		
		if(book == null)
			throw new RuntimeException ("Did not find th book id " +id);
		else 
			return book;
		
	}
	

	
	

}
