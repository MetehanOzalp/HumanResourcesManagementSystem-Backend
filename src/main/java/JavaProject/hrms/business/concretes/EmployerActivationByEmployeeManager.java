package JavaProject.hrms.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.EmployerActivationByEmployeeService;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.core.utilities.results.SuccessResult;
import JavaProject.hrms.dataAccess.abstracts.EmployerActivationByEmployeeDao;
import JavaProject.hrms.entities.concretes.EmployerActivationByEmployee;

@Service
public class EmployerActivationByEmployeeManager implements EmployerActivationByEmployeeService {

	private EmployerActivationByEmployeeDao employerActivationByEmployeeDao;

	@Autowired
	public EmployerActivationByEmployeeManager(EmployerActivationByEmployeeDao employerActivationByEmployeeDao) {
		super();
		this.employerActivationByEmployeeDao = employerActivationByEmployeeDao;
	}

	@Override
	public Result add(EmployerActivationByEmployee employerActivationByEmployee) {
		employerActivationByEmployee.setVerified(true);
		employerActivationByEmployee.setVerifiedDate(LocalDate.now());
		employerActivationByEmployeeDao.save(employerActivationByEmployee);
		return new SuccessResult("İşveren onaylandı");
	}

}
