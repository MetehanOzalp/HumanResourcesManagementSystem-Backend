package JavaProject.hrms.business.abstracts;

import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {

	Result add(JobSeeker jobSeeker);

	DataResult<JobSeeker> getByNationalityNumber(String nationalityNumber);
}
