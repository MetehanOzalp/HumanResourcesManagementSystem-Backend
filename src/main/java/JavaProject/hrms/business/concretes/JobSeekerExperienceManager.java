package JavaProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.JobSeekerExperienceService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.core.utilities.results.SuccessDataResult;
import JavaProject.hrms.core.utilities.results.SuccessResult;
import JavaProject.hrms.dataAccess.abstracts.JobSeekerExperienceDao;
import JavaProject.hrms.entities.concretes.JobSeekerExperience;

@Service
public class JobSeekerExperienceManager implements JobSeekerExperienceService {

	private JobSeekerExperienceDao jobSeekerExperienceDao;

	@Autowired
	public JobSeekerExperienceManager(JobSeekerExperienceDao jobSeekerExperienceDao) {
		super();
		this.jobSeekerExperienceDao = jobSeekerExperienceDao;
	}

	@Override
	public Result add(JobSeekerExperience jobSeekerExperience) {
		jobSeekerExperienceDao.save(jobSeekerExperience);
		return new SuccessResult("Deneyim eklendi");
	}

	@Override
	public Result update(JobSeekerExperience jobSeekerExperience) {
		jobSeekerExperienceDao.save(jobSeekerExperience);
		return new SuccessResult("Deneyim bilgisi güncellendi!");
	}

	@Override
	public DataResult<List<JobSeekerExperience>> getByDateOfFinishSorted(int jobSeekerId) {
		Sort sort = Sort.by(Sort.Direction.DESC, "endDate");
		return new SuccessDataResult<List<JobSeekerExperience>>(
				jobSeekerExperienceDao.getByCurriculumVitae_JobSeeker_id(jobSeekerId, sort));
	}

}
