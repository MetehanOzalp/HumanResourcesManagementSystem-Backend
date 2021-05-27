package JavaProject.hrms.core.utilities.helpers.email;

import JavaProject.hrms.core.utilities.results.Result;

public interface EmailService {

	Result sendEmail(String to, String title, String body);

}
