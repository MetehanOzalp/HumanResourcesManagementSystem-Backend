package JavaProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.EmployerService;
import JavaProject.hrms.core.utilities.business.BusinessRules;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.ErrorResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.core.utilities.results.SuccessDataResult;
import JavaProject.hrms.core.utilities.results.SuccessResult;
import JavaProject.hrms.dataAccess.abstracts.EmployerDao;
import JavaProject.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public Result add(Employer employer) {
		var result = BusinessRules.run(checkIfInformation(employer));
		if (result != null) {
			return result;
		}
		employerDao.save(employer);
		return new SuccessResult("İşveren eklendi");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "İşverenler listelendi");
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(employerDao.getById(id));
	}

	public Result checkIfInformation(Employer employer) {
		if (employer.getEmail() == "" || employer.getCompanyName() == "" || employer.getPassword() == ""
				|| employer.getPhoneNumber() == "" || employer.getWebSite() == "") {
			return new ErrorResult("Lütfen tüm alanları doldurun");
		}
		return new SuccessResult();
	}

}
