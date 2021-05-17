package JavaProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.JobPositionService;
import JavaProject.hrms.dataAccess.abstracts.JobPositionDao;
import JavaProject.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public List<JobPosition> getAll() {
		return jobPositionDao.findAll();
	}

}
