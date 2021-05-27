package JavaProject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import JavaProject.hrms.entities.concretes.ActivationCodeToJobSeeker;

public interface ActivationCodeToJobSeekerDao extends JpaRepository<ActivationCodeToJobSeeker, Integer> {
	ActivationCodeToJobSeeker getByJobSeekerId(int id);

}
