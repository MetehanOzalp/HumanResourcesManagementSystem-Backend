package JavaProject.hrms.business.abstracts;

import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.ActivationCodeToJobSeeker;

public interface ActivationCodeToJobSeekerService {

	Result add(ActivationCodeToJobSeeker activationCodeToJobSeeker);

	Result verify(String code);

	DataResult<ActivationCodeToJobSeeker> getByJobSeekerId(int id);

}
