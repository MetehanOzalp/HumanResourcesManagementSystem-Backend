package JavaProject.hrms.core.adapters;

public interface UserCheckService {

	boolean validate(String nationalityId, String firstName, String lastName, int birthYear);

}
