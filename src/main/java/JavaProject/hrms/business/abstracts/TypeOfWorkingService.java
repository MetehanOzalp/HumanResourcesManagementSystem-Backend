package JavaProject.hrms.business.abstracts;

import java.util.List;

import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.TypeOfWorking;

public interface TypeOfWorkingService {

	Result add(TypeOfWorking typeOfWorking);

	DataResult<List<TypeOfWorking>> getAll();

}
