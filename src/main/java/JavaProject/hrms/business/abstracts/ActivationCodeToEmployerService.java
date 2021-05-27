package JavaProject.hrms.business.abstracts;

import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.ActivationCodeToEmployer;

public interface ActivationCodeToEmployerService {

	Result add(ActivationCodeToEmployer activationCodeToEmployer);

	Result verify(String code);

	DataResult<ActivationCodeToEmployer> getByEmployerId(int id);

}
