package JavaProject.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import JavaProject.hrms.entities.concretes.JobPosting;
import JavaProject.hrms.entities.dtos.JobPostingFilter;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {

	JobPosting getById(int id);

	List<JobPosting> getByIsConfirm(boolean isActive);

	List<JobPosting> getByIsConfirm(boolean isActive, Sort sort);

	List<JobPosting> getByIsConfirm(boolean isActive, Pageable pageable);

	@Query("Select j from JavaProject.hrms.entities.concretes.JobPosting j where ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
			+ " and ((:#{#filter.jobPositionId}) IS NULL OR j.jobPosition.id IN (:#{#filter.jobPositionId}))"
			+ " and ((:#{#filter.wayOfWorkingId}) IS NULL OR j.wayOfWorking.id IN (:#{#filter.wayOfWorkingId}))"
			+ " and ((:#{#filter.typeOfWorkingId}) IS NULL OR j.typeOfWorking.id IN (:#{#filter.typeOfWorkingId}))"
			+ " and ((:#{#isConfirm}) IS NULL OR j.isConfirm = (:#{#isConfirm})) and j.isActive = true")
	List<JobPosting> getByFilter(@Param("isConfirm") boolean isActive,
			@Param("filter") JobPostingFilter jobPostingFilter, Pageable pageable);

	List<JobPosting> getByIsActiveAndEmployer_id(boolean isActive, int id);

}
