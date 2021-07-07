package JavaProject.hrms.business.abstracts;

import java.util.List;

import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.JobPosting;
import JavaProject.hrms.entities.dtos.JobPostingFilter;

public interface JobPostingService {

	Result add(JobPosting jobPosting);

	Result delete(int jobPostingId);

	Result changeJobPostingStatus(int jobPostingId);

	DataResult<JobPosting> getByJobPostingId(int jobPostingId);

	DataResult<List<JobPosting>> getByIsConfirmAndPageNumber(boolean isActice, int pageNumber);

	DataResult<List<JobPosting>> getByIsConfirmAndPageNumberAndFilter(boolean isActice, int pageNumber,
			JobPostingFilter jobPostingFilter);

	DataResult<List<JobPosting>> getByActiveOrPassiveJobPostings(boolean isActive);

	DataResult<List<JobPosting>> getByReleaseDateJobPosting(int value);

	DataResult<List<JobPosting>> getByEmployerJobPosting(int employerId);

}
