package JavaProject.hrms.business.abstracts;

import java.util.List;

import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.JobSeekerExperience;

public interface JobSeekerExperienceService {

	Result add(JobSeekerExperience jobSeekerExperience);

	Result update(JobSeekerExperience jobSeekerExperience);

	DataResult<List<JobSeekerExperience>> getByDateOfFinishSorted(int jobSeekerId);

}
