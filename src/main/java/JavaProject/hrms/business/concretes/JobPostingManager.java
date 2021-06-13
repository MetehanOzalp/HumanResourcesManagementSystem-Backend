package JavaProject.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.JobPositionService;
import JavaProject.hrms.business.abstracts.JobPostingService;
import JavaProject.hrms.core.utilities.business.BusinessRules;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.ErrorDataResult;
import JavaProject.hrms.core.utilities.results.ErrorResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.core.utilities.results.SuccessDataResult;
import JavaProject.hrms.core.utilities.results.SuccessResult;
import JavaProject.hrms.dataAccess.abstracts.JobPostingDao;
import JavaProject.hrms.entities.concretes.City;
import JavaProject.hrms.entities.concretes.Employer;
import JavaProject.hrms.entities.concretes.JobPosition;
import JavaProject.hrms.entities.concretes.JobPosting;
import JavaProject.hrms.entities.concretes.TypeOfWorking;
import JavaProject.hrms.entities.concretes.WayOfWorking;
import JavaProject.hrms.entities.dtos.JobPostingAddDto;

@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;
	private JobPositionService jobPositionService;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao, JobPositionService jobPositionService) {
		super();
		this.jobPostingDao = jobPostingDao;
		this.jobPositionService = jobPositionService;
	}

	@Override
	public Result add(JobPostingAddDto jobPostingAddDto) {
		JobPosting jobPosting = new JobPosting(0, jobPostingAddDto.getJobDescription(), jobPostingAddDto.getMinSalary(),
				jobPostingAddDto.getMaxSalary(), jobPostingAddDto.getOpenPositionCount(),
				jobPostingAddDto.getApplicationDeadline(), false, null,
				new TypeOfWorking(jobPostingAddDto.getTypeOfWorkingId(), null, null),
				new WayOfWorking(jobPostingAddDto.getWayOfWorkingId(), null, null),
				new Employer(jobPostingAddDto.getEmployerId(), null, null, null, null, null),
				new JobPosition(jobPostingAddDto.getJobPositionId(), null, null),
				new City(jobPostingAddDto.getCityId(), null, null));
		var result = BusinessRules.run(checkIfEndDateValid(jobPosting),
				checkIfJobPositionExists(jobPosting.getJobPosition().getId()));
		if (result != null) {
			return result;
		}
		jobPosting.setActive(false);
		jobPosting.setReleaseDate(LocalDate.now());
		jobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public Result delete(int jobPostingId) {
		jobPostingDao.deleteById(jobPostingId);
		return null;
	}

	@Override
	public Result changeJobPostingStatus(int jobPostingId) {
		var jobPosting = getByJobPostingId(jobPostingId);
		if (!jobPosting.isSuccess()) {
			return new ErrorResult(jobPosting.getMessage());
		}
		jobPosting.getData().setActive(!jobPosting.getData().isActive());
		jobPostingDao.save(jobPosting.getData());
		return new SuccessResult("İlan durumu değiştirildi");
	}

	@Override
	public DataResult<JobPosting> getByJobPostingId(int jobPostingId) {
		var result = jobPostingDao.getById(jobPostingId);
		if (result == null) {
			return new ErrorDataResult<JobPosting>("Böyle bir iş ilanı bulunamadı");
		}
		return new SuccessDataResult<JobPosting>(result);
	}

	@Override
	public DataResult<List<JobPosting>> getByActiveOrPassiveJobPostings(boolean isActive) {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByIsActive(isActive));
	}

	@Override
	public DataResult<List<JobPosting>> getByReleaseDateJobPosting(int value) {
		Sort sort;
		if (value == 0) {
			sort = Sort.by(Sort.Direction.DESC, "releaseDate");
		} else {
			sort = Sort.by(Sort.Direction.ASC, "releaseDate");
		}
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByIsActive(true, sort));
	}

	@Override
	public DataResult<List<JobPosting>> getByEmployerJobPosting(int employerId) {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByIsActiveAndEmployer_id(true, employerId));
	}

	public Result checkIfEndDateValid(JobPosting jobPosting) {
		if (jobPosting.getApplicationDeadline().isBefore(LocalDate.now())) {
			return new ErrorResult("Son başvuru tarihi bu tarihten önce olamaz");
		}
		return new SuccessResult();
	}

	public Result checkIfJobPositionExists(int jobPositionId) {
		var result = jobPositionService.getById(jobPositionId);
		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		return new SuccessResult();
	}

}
