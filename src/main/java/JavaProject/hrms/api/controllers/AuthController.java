package JavaProject.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.AuthService;
import JavaProject.hrms.core.utilities.results.ErrorDataResult;
import JavaProject.hrms.entities.dtos.EmployerForRegisterDto;
import JavaProject.hrms.entities.dtos.JobSeekerForRegisterDto;

import org.springframework.http.HttpStatus;

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
	public ResponseEntity<?> registerForJobSeeker(@Valid @RequestBody JobSeekerForRegisterDto jobSeekerForRegisterDto) {
		var result = authService.registerForJobSeeker(jobSeekerForRegisterDto);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

	@PostMapping("registerForEmployer")
	public ResponseEntity<?> registerForEmployer(@Valid @RequestBody EmployerForRegisterDto employerForRegisterDto) {
		var result = authService.registerForEmployer(employerForRegisterDto);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationExceptions(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
	}

}
