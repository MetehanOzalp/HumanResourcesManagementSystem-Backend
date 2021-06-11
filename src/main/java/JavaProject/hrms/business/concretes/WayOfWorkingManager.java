package JavaProject.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.WayOfWorkingService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.core.utilities.results.SuccessDataResult;
import JavaProject.hrms.core.utilities.results.SuccessResult;
import JavaProject.hrms.dataAccess.abstracts.WayOfWorkingDao;
import JavaProject.hrms.entities.concretes.WayOfWorking;

@Service
public class WayOfWorkingManager implements WayOfWorkingService {

	private WayOfWorkingDao wayOfWorkingDao;

	public WayOfWorkingManager(WayOfWorkingDao wayOfWorkingDao) {
		super();
		this.wayOfWorkingDao = wayOfWorkingDao;
	}

	@Override
	public Result add(WayOfWorking wayOfWorking) {
		wayOfWorkingDao.save(wayOfWorking);
		return new SuccessResult("Çalışma şekli eklendi");
	}

	@Override
	public DataResult<List<WayOfWorking>> getAll() {
		return new SuccessDataResult<List<WayOfWorking>>(wayOfWorkingDao.findAll());
	}

}
