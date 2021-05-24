package JavaProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.JobSeekerService;
import JavaProject.hrms.core.utilities.business.BusinessRules;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.ErrorResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.core.utilities.results.SuccessDataResult;
import JavaProject.hrms.core.utilities.results.SuccessResult;
import JavaProject.hrms.dataAccess.abstracts.JobSeekerDao;
import JavaProject.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		var result = BusinessRules.run(checkIfInformation(jobSeeker));
		if (result != null) {
			return result;
		}
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş arayan eklendi");
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll());
	}

	@Override
	public DataResult<JobSeeker> getByNationalityNumber(String nationalityNumber) {
		return new SuccessDataResult<JobSeeker>(jobSeekerDao.getByNationalityId(nationalityNumber));
	}

	public Result checkIfInformation(JobSeeker jobSeeker) {
		if (jobSeeker.getEmail() == "" || jobSeeker.getPassword() == "" || jobSeeker.getFirstName() == ""
				|| jobSeeker.getLastName() == "" || jobSeeker.getNationalityId() == ""
				|| jobSeeker.getBirthYear() == 0) {
			return new ErrorResult("Lütfen tüm alanları doldurun");
		}
		return new SuccessResult();

	}

}
