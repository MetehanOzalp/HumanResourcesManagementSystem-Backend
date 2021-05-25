package JavaProject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.AuthService;
import JavaProject.hrms.business.abstracts.EmployerService;
import JavaProject.hrms.business.abstracts.JobSeekerService;
import JavaProject.hrms.business.abstracts.UserService;
import JavaProject.hrms.core.adapters.mernis.MernisServiceAdapter;
import JavaProject.hrms.core.adapters.mernis.UserCheckService;
import JavaProject.hrms.core.utilities.business.BusinessRules;
import JavaProject.hrms.core.utilities.results.ErrorResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.core.utilities.results.SuccessResult;
import JavaProject.hrms.entities.concretes.Employer;
import JavaProject.hrms.entities.concretes.JobSeeker;
import JavaProject.hrms.entities.dtos.EmployerForRegisterDto;
import JavaProject.hrms.entities.dtos.JobSeekerForRegisterDto;

@Service
public class AuthManager implements AuthService {

	private UserService userService;
	private JobSeekerService jobSeekerService;
	private EmployerService employerService;

	@Autowired
	public AuthManager(UserService userService, JobSeekerService jobSeekerService, EmployerService employerService) {
		super();
		this.userService = userService;
		this.jobSeekerService = jobSeekerService;
		this.employerService = employerService;
	}

	@Override
	public Result registerForJobSeeker(JobSeekerForRegisterDto jobSeekerForRegisterDto) {
		var result = BusinessRules.run(checkIfEmailExists(jobSeekerForRegisterDto.getEmail()),
				checkIfNationalityNumberExists(jobSeekerForRegisterDto.getNationalityId()),
				checkIfPasswordsSame(jobSeekerForRegisterDto.getPassword(),
						jobSeekerForRegisterDto.getPasswordRepeat()),
				checkIfRealPerson(jobSeekerForRegisterDto.getNationalityId(), jobSeekerForRegisterDto.getFirstName(),
						jobSeekerForRegisterDto.getLastName(), jobSeekerForRegisterDto.getBirthYear()));
		if (result != null) {
			return result;
		}

		JobSeeker jobSeeker = new JobSeeker(0, jobSeekerForRegisterDto.getEmail(),
				jobSeekerForRegisterDto.getPassword(), jobSeekerForRegisterDto.getFirstName(),
				jobSeekerForRegisterDto.getLastName(), jobSeekerForRegisterDto.getNationalityId(),
				jobSeekerForRegisterDto.getBirthYear());

		var added = jobSeekerService.add(jobSeeker);
		if (!added.isSuccess()) {
			return added;
		}
		return new SuccessResult("İş arayan eklendi");
	}

	@Override
	public Result registerForEmployer(EmployerForRegisterDto employerForRegisterDto) {
		var result = BusinessRules.run(
				checkIfPasswordsSame(employerForRegisterDto.getPassword(), employerForRegisterDto.getPasswordRepeat()),
				checkIfDomainSame(employerForRegisterDto.getEmail(), employerForRegisterDto.getWebSite()),
				checkIfEmailExists(employerForRegisterDto.getEmail()));
		if (result != null) {
			return result;
		}
		Employer employer = new Employer(0, employerForRegisterDto.getEmail(), employerForRegisterDto.getPassword(),
				employerForRegisterDto.getCompanyName(), employerForRegisterDto.getWebSite(),
				employerForRegisterDto.getPhoneNumber());
		return employerService.add(employer);
	}

	public Result checkIfRealPerson(String nationalityId, String firstName, String lastName, int birthYear) {
		UserCheckService userCheckService = new MernisServiceAdapter();
		var result = userCheckService.validate(nationalityId, firstName, lastName, birthYear);
		if (!result) {
			return new ErrorResult("Kimlik bilgileri yanlış");
		}

		return new SuccessResult();
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

	public Result checkIfPasswordsSame(String password, String passwordRepeat) {
		if (!password.equals(passwordRepeat)) {
			return new ErrorResult("Şifreler farklı");
		}
		return new SuccessResult();
	}

	public Result checkIfDomainSame(String email, String webSite) {
		String[] emailDomain = email.split("@");
		if (!emailDomain[1].equals(webSite)) {
			return new ErrorResult("E-posta ve web site alan isimleri farklı");
		}
		return new SuccessResult();
	}

}
