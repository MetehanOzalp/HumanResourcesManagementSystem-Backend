package JavaProject.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import JavaProject.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {

	JobPosting getById(int id);

	List<JobPosting> getByIsActive(boolean isActive);

	List<JobPosting> getByIsActive(boolean isActive, Sort sort);

	List<JobPosting> getByIsActiveAndEmployer_id(boolean isActive, int id);

}
