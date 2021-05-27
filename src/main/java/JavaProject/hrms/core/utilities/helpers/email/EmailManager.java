package JavaProject.hrms.core.utilities.helpers.email;

import org.springframework.stereotype.Service;

import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.core.utilities.results.SuccessResult;

@Service
public class EmailManager implements EmailService {

	@Override
	public Result sendEmail(String to, String title, String body) {
		System.out.println("Email sending : " + body);
		return new SuccessResult("Email sending");
	}

}
