package JavaProject.hrms.entities.dtos;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerForRegisterDto {

	@NotBlank(message = "İsim alanı boş bırakılamaz")
	@NotNull
	private String firstName;

	@NotBlank(message = "Soyisim alanı boş bırakılamaz")
	@NotNull
	private String lastName;

	@NotBlank(message = "TC kimlik numarası boş bırakılamaz")
	@NotNull
	private String nationalityId;

	@NotNull
	private int birthYear;

	@NotBlank(message = "E-Posta alanı boş bırakılamaz")
	@NotNull
	private String email;

	@NotBlank(message = "Şifre alanı boş bırakılamaz")
	@NotNull
	private String password;

	@NotBlank(message = "Şifre tekrarı alanı boş bırakılamaz")
	@NotNull
	private String passwordRepeat;

}
