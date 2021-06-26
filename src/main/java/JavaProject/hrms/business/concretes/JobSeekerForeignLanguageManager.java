package JavaProject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.JobSeekerForeignLanguageService;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.core.utilities.results.SuccessResult;
import JavaProject.hrms.dataAccess.abstracts.JobSeekerForeignLanguageDao;
import JavaProject.hrms.entities.concretes.JobSeekerForeignLanguage;

@Service
public class JobSeekerForeignLanguageManager implements JobSeekerForeignLanguageService {

	private JobSeekerForeignLanguageDao jobSeekerForeignLanguageDao;

	@Autowired
	public JobSeekerForeignLanguageManager(JobSeekerForeignLanguageDao jobSeekerForeignLanguageDao) {
		super();
		this.jobSeekerForeignLanguageDao = jobSeekerForeignLanguageDao;
	}

	@Override
	public Result add(JobSeekerForeignLanguage jobSeekerForeignLanguage) {
		jobSeekerForeignLanguageDao.save(jobSeekerForeignLanguage);
		return new SuccessResult("Yabancı dil eklendi");
	}

	@Override
	public Result update(JobSeekerForeignLanguage jobSeekerForeignLanguage) {
		jobSeekerForeignLanguageDao.save(jobSeekerForeignLanguage);
		return new SuccessResult("Yabancı dil bilgisi güncellendi");
	}

	@Override
	public Result delete(int id) {
		jobSeekerForeignLanguageDao.deleteById(id);
		return new SuccessResult("Yabancı dil bilgisi silindi");
	}

}
