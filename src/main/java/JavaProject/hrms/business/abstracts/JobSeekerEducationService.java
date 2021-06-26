package JavaProject.hrms.business.abstracts;

import java.util.List;

import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.JobSeekerEducation;

public interface JobSeekerEducationService {

	Result add(JobSeekerEducation jobSeekerEducation);
	
	Result update(JobSeekerEducation jobSeekerEducation);

	DataResult<List<JobSeekerEducation>> getByDateOfGraduationSorted(int jobSeekerId);

}
