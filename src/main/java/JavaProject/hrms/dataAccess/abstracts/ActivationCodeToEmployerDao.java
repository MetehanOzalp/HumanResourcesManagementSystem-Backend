package JavaProject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import JavaProject.hrms.entities.concretes.ActivationCodeToEmployer;

public interface ActivationCodeToEmployerDao extends JpaRepository<ActivationCodeToEmployer, Integer> {
	ActivationCodeToEmployer getByEmployerId(int employerId);

}
