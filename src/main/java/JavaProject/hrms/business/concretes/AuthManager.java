package JavaProject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.AuthService;
import JavaProject.hrms.business.abstracts.JobSeekerService;
import JavaProject.hrms.business.abstracts.UserService;
import JavaProject.hrms.core.utilities.business.BusinessRules;
import JavaProject.hrms.core.utilities.results.ErrorResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.core.utilities.results.SuccessResult;
import JavaProject.hrms.entities.concretes.JobSeeker;
import JavaProject.hrms.entities.dtos.JobSeekerForRegisterDto;

@Service
public class AuthManager implements AuthService {

	private JobSeekerService jobSeekerService;
	private UserService userService;

	@Autowired
	public AuthManager(UserService userService, JobSeekerService jobSeekerService) {
		super();
		this.userService = userService;
		this.jobSeekerService = jobSeekerService;
	}

	@Override
	public Result registerForJobSeeker(JobSeekerForRegisterDto jobSeekerForRegisterDto) {
		var result = BusinessRules.run(checkIfEmailExists(jobSeekerForRegisterDto.getEmail()),
				checkIfNationalityNumberExists(jobSeekerForRegisterDto.getNationalityId()),
				checkIfPasswordsSame(jobSeekerForRegisterDto));
		if (result != null) {
			return result;
		}

		JobSeeker jobSeeker = new JobSeeker(0, jobSeekerForRegisterDto.getEmail(),
				jobSeekerForRegisterDto.getPassword(), jobSeekerForRegisterDto.getFirstName(),
				jobSeekerForRegisterDto.getLastName(), jobSeekerForRegisterDto.getNationalityId(),
				jobSeekerForRegisterDto.getBirthYear());

		jobSeekerService.add(jobSeeker);

		return new SuccessResult("İş arayan eklendi");
	}

	public Result checkIfEmailExists(String email) {
		var result = userService.getByEmail(email);
		if (result.getData() != null) {
			return new ErrorResult("Bu e-posta zaten kayıtlı");
		}
		return new SuccessResult();
	}

	public Result checkIfNationalityNumberExists(String nationalityNumber) {
		var result = jobSeekerService.getByNationalityNumber(nationalityNumber);
		if (result.getData() != null) {
			return new ErrorResult("Bu TC kimlik numarası zaten kayıtlı");
		}
		return new SuccessResult();
	}

	public Result checkIfPasswordsSame(JobSeekerForRegisterDto jobSeekerForRegisterDto) {
		if (!jobSeekerForRegisterDto.getPassword().equals(jobSeekerForRegisterDto.getPasswordRepeat())) {
			return new ErrorResult("Şifreler farklı");
		}
		return new SuccessResult();
	}

}
