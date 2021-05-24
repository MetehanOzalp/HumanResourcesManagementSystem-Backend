package JavaProject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import JavaProject.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User getByEmail(String email);
}
