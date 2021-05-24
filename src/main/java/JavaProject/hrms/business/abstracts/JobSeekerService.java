package JavaProject.hrms.business.abstracts;

import java.util.List;

import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {

	Result add(JobSeeker jobSeeker);

	DataResult<List<JobSeeker>> getAll();

	DataResult<JobSeeker> getByNationalityNumber(String nationalityNumber);
}
