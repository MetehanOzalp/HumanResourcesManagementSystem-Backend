package JavaProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.JobSeekerEducationService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.core.utilities.results.SuccessDataResult;
import JavaProject.hrms.core.utilities.results.SuccessResult;
import JavaProject.hrms.dataAccess.abstracts.JobSeekerEducationDao;
import JavaProject.hrms.entities.concretes.JobSeekerEducation;

@Service
public class JobSeekerEducationManager implements JobSeekerEducationService {

	private JobSeekerEducationDao jobSeekerEducationDao;

	@Autowired
	public JobSeekerEducationManager(JobSeekerEducationDao jobSeekerEducationDao) {
		super();
		this.jobSeekerEducationDao = jobSeekerEducationDao;
	}

	@Override
	public Result add(JobSeekerEducation jobSeekerEducation) {
		jobSeekerEducationDao.save(jobSeekerEducation);
		return new SuccessResult("Eğitim eklendi");
	}

	@Override
	public Result update(JobSeekerEducation jobSeekerEducation) {
		jobSeekerEducationDao.save(jobSeekerEducation);
		return new SuccessResult("Eğitim bilgisi güncellendi");
	}

	@Override
	public DataResult<List<JobSeekerEducation>> getByDateOfGraduationSorted(int jobSeekerId) {
		Sort sort = Sort.by(Sort.Direction.DESC, "endDate");
		return new SuccessDataResult<List<JobSeekerEducation>>(
				jobSeekerEducationDao.getByCurriculumVitae_JobSeeker_id(jobSeekerId, sort));
	}

}
