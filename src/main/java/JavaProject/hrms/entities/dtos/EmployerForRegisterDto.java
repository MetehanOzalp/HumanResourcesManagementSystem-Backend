package JavaProject.hrms.entities.dtos;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerForRegisterDto {

	@NotBlank(message = "E-Posta alanı boş olamaz")
	@NotNull
	private String email;

	@NotBlank(message = "Şirket adı alanı boş olamaz")
	@NotNull
	private String companyName;

	@NotBlank(message = "Web site alanı boş olamaz")
	@NotNull
	private String webSite;

	@NotBlank(message = "Telefon numarası alanı boş olamaz")
	@NotNull
	private String phoneNumber;

	@NotBlank(message = "Şifre alanı boş olamaz")
	@NotNull
	private String password;

	@NotBlank(message = "Şifre tekrarı alanı boş olamaz")
	@NotNull
	private String passwordRepeat;

}
