package JavaProject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.EmployerService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers/")
public class EmployersController {

	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}

	@GetMapping("getall")
	public DataResult<List<Employer>> getAll() {
		return employerService.getAll();
	}

}
