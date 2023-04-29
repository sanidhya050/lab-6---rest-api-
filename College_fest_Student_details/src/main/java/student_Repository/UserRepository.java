package student_Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import student_entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	public User findByUserName(String username);

}
