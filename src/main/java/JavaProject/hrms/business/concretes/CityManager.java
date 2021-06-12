package JavaProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.CityService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.SuccessDataResult;
import JavaProject.hrms.dataAccess.abstracts.CityDao;
import JavaProject.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(cityDao.findAll());
	}

}
