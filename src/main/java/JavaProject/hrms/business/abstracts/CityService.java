package JavaProject.hrms.business.abstracts;

import java.util.List;

import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getAll();

}
