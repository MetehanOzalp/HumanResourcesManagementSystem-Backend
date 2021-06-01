package JavaProject.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import JavaProject.hrms.entities.concretes.JobSeekerEducation;

public interface JobSeekerEducationDao extends JpaRepository<JobSeekerEducation, Integer> {

	List<JobSeekerEducation> getByCurriculumVitae_JobSeeker_id(int id);

	List<JobSeekerEducation> getByCurriculumVitae_JobSeeker_id(int id, Sort sort);

}
