package JavaProject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import JavaProject.hrms.entities.concretes.JobSeekerEducation;

public interface JobSeekerEducationDao extends JpaRepository<JobSeekerEducation, Integer> {

}
