package JavaProject.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerForRegisterDto {

	private String firstName;
	private String lastName;
	private String nationalityId;
	private int birthYear;
	private String email;
	private String password;
	private String passwordRepeat;

}
