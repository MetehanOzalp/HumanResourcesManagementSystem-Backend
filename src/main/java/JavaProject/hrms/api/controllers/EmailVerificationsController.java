package JavaProject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.ActivationCodeToEmployerService;
import JavaProject.hrms.business.abstracts.ActivationCodeToJobSeekerService;
import JavaProject.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/emailVerifications/")
public class EmailVerificationsController {

	private ActivationCodeToEmployerService activationCodeToEmployerService;
	private ActivationCodeToJobSeekerService activationCodeToJobSeekerService;

	@Autowired
	public EmailVerificationsController(ActivationCodeToEmployerService activationCodeToEmployerService,
			ActivationCodeToJobSeekerService activationCodeToJobSeekerService) {
		super();
		this.activationCodeToEmployerService = activationCodeToEmployerService;
		this.activationCodeToJobSeekerService = activationCodeToJobSeekerService;
	}

	@GetMapping("employerActivation")
	public Result employerActivation(String code) {
		return activationCodeToEmployerService.verify(code);
	}

	@GetMapping("jobSeekerActivation")
	public Result jobSeekerActivation(String code) {
		return activationCodeToJobSeekerService.verify(code);
	}

}
