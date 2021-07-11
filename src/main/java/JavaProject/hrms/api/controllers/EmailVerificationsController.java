package JavaProject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.ActivationCodeToEmployerService;
import JavaProject.hrms.business.abstracts.ActivationCodeToJobSeekerService;

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
	public ResponseEntity<?> employerActivation(@RequestParam String code) {
		var result = activationCodeToEmployerService.verify(code);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

	@GetMapping("jobSeekerActivation")
	public ResponseEntity<?> jobSeekerActivation(@RequestParam String code) {
		var result = activationCodeToJobSeekerService.verify(code);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

}
