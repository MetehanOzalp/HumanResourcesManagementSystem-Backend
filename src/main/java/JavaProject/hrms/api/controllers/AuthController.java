package JavaProject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.AuthService;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.dtos.EmployerForRegisterDto;
import JavaProject.hrms.entities.dtos.JobSeekerForRegisterDto;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}

	@PostMapping("registerForJobSeeker")
	public Result registerForJobSeeker(@RequestBody JobSeekerForRegisterDto jobSeekerForRegisterDto) {
		return authService.registerForJobSeeker(jobSeekerForRegisterDto);
	}

	@PostMapping("registerForEmployer")
	public Result registerForEmployer(@RequestBody EmployerForRegisterDto employerForRegisterDto) {
		return authService.registerForEmployer(employerForRegisterDto);
	}

}
