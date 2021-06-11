package JavaProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.TypeOfWorkingService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.core.utilities.results.SuccessDataResult;
import JavaProject.hrms.core.utilities.results.SuccessResult;
import JavaProject.hrms.dataAccess.abstracts.TypeOfWorkingDao;
import JavaProject.hrms.entities.concretes.TypeOfWorking;

@Service
public class TypeOfWorkingManager implements TypeOfWorkingService {

	private TypeOfWorkingDao typeOfWorkingDao;

	@Autowired
	public TypeOfWorkingManager(TypeOfWorkingDao typeOfWorkingDao) {
		super();
		this.typeOfWorkingDao = typeOfWorkingDao;
	}

	@Override
	public Result add(TypeOfWorking typeOfWorking) {
		typeOfWorkingDao.save(typeOfWorking);
		return new SuccessResult("Çalışma türü eklendi");
	}

	@Override
	public DataResult<List<TypeOfWorking>> getAll() {
		return new SuccessDataResult<List<TypeOfWorking>>(typeOfWorkingDao.findAll());
	}

}
