package JavaProject.hrms.business.abstracts;

import java.util.List;

import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.JobPosting;

public interface JobPostingService {

	Result add(JobPosting jobPosting);

	Result changeJobPostingStatus(int jobPostingId);

	DataResult<JobPosting> getByJobPostingId(int jobPostingId);

	DataResult<List<JobPosting>> getByActiveJobPostings();

	DataResult<List<JobPosting>> getByReleaseDateJobPosting(int value);

	DataResult<List<JobPosting>> getByEmployerJobPosting(int employerId);

}
