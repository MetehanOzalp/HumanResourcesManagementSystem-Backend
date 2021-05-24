package JavaProject.hrms.business.abstracts;

import java.util.List;

import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.Employer;

public interface EmployerService {

	Result add(Employer employer);

	DataResult<List<Employer>> getAll();

}
