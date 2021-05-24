package JavaProject.hrms.business.abstracts;

import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.entities.concretes.User;

public interface UserService {

	DataResult<User> getByEmail(String email);

}
