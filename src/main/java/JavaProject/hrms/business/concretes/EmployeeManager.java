package JavaProject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.EmployeeService;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.core.utilities.results.SuccessResult;
import JavaProject.hrms.dataAccess.abstracts.EmployeeDao;
import JavaProject.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public Result add(Employee systemPersonnel) {
		employeeDao.save(systemPersonnel);
		return new SuccessResult("Sistem personeli eklendi");
	}

}
