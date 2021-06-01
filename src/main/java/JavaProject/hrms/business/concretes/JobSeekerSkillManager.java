package JavaProject.hrms.business.concretes;

import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.JobSeekerSkillService;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.core.utilities.results.SuccessResult;
import JavaProject.hrms.dataAccess.abstracts.JobSeekerSkillDao;
import JavaProject.hrms.entities.concretes.JobSeekerSkill;

@Service
public class JobSeekerSkillManager implements JobSeekerSkillService {

	private JobSeekerSkillDao jobSeekerSkillDao;

	public JobSeekerSkillManager(JobSeekerSkillDao jobSeekerSkillDao) {
		super();
		this.jobSeekerSkillDao = jobSeekerSkillDao;
	}

	@Override
	public Result add(JobSeekerSkill jobSeekerSkill) {
		jobSeekerSkillDao.save(jobSeekerSkill);
		return new SuccessResult("Yetenek eklendi");
	}

}
