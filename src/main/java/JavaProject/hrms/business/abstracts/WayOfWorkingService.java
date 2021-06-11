package JavaProject.hrms.business.abstracts;

import java.util.List;

import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.WayOfWorking;

public interface WayOfWorkingService {

	Result add(WayOfWorking wayOfWorking);

	DataResult<List<WayOfWorking>> getAll();

}
