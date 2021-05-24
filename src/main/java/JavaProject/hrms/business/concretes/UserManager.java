package JavaProject.hrms.business.concretes;

import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.UserService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.SuccessDataResult;
import JavaProject.hrms.dataAccess.abstracts.UserDao;
import JavaProject.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(userDao.getByEmail(email));
	}

}
