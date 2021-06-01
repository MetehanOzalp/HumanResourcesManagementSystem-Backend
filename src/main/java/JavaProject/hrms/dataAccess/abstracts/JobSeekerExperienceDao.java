package JavaProject.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import JavaProject.hrms.entities.concretes.JobSeekerExperience;

public interface JobSeekerExperienceDao extends JpaRepository<JobSeekerExperience, Integer> {

	List<JobSeekerExperience> getByCurriculumVitae_JobSeeker_id(int id);

	List<JobSeekerExperience> getByCurriculumVitae_JobSeeker_id(int id, Sort sort);

}
