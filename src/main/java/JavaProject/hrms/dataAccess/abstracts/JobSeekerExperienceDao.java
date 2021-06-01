package JavaProject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import JavaProject.hrms.entities.concretes.JobSeekerExperience;

public interface JobSeekerExperienceDao extends JpaRepository<JobSeekerExperience, Integer> {

}
