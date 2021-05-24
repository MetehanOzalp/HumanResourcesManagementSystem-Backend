package JavaProject.hrms.business.abstracts;

import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.dtos.EmployerForRegisterDto;
import JavaProject.hrms.entities.dtos.JobSeekerForRegisterDto;

public interface AuthService {

	Result registerForJobSeeker(JobSeekerForRegisterDto jobSeekerForRegisterDto);

	Result registerForEmployer(EmployerForRegisterDto employerForRegisterDto);

}
