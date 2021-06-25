package JavaProject.hrms.business.abstracts;

import java.util.List;

import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.Employee;

public interface EmployeeService {

	Result add(Employee employee);

	Result update(Employee employee);

	DataResult<List<Employee>> getAll();

}
