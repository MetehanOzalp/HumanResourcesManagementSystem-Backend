package JavaProject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.EmployerActivationByEmployeeService;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.EmployerActivationByEmployee;

@RestController
@RequestMapping("/api/employerActivationByEmployees/")
public class EmployerActivationByEmployeesController {

	private EmployerActivationByEmployeeService employerActivationByEmployeeService;

	@Autowired
	public EmployerActivationByEmployeesController(
			EmployerActivationByEmployeeService employerActivationByEmployeeService) {
		super();
		this.employerActivationByEmployeeService = employerActivationByEmployeeService;
	}

	@PostMapping("add")
	public Result add(EmployerActivationByEmployee employerActivationByEmployee) {
		return employerActivationByEmployeeService.add(employerActivationByEmployee);
	}

}
