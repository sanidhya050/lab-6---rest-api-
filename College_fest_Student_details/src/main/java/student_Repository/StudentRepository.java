package student_Repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import student_entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


	

}
