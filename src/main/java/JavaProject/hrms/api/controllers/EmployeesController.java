package JavaProject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.EmployeeService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees/")
@CrossOrigin
public class EmployeesController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping("add")
	public Result add(@RequestBody Employee employee) {
		return employeeService.add(employee);
	}

	@PostMapping("update")
	public Result update(@RequestBody Employee employee) {
		return employeeService.update(employee);
	}

	@GetMapping("getall")
	public DataResult<List<Employee>> getAll() {
		return employeeService.getAll();
	}

}
