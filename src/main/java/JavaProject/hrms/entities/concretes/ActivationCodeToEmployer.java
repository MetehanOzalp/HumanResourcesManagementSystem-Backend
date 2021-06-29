package JavaProject.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "activation_code_to_employers")
@PrimaryKeyJoinColumn(name = "id")
@NoArgsConstructor
public class ActivationCodeToEmployer extends ActivationCode {

	@Column(name = "employer_id")
	private int employerId;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "employer_id", insertable = false, updatable = false)
	private Employer employer;

	public ActivationCodeToEmployer(int id, String activationCode, boolean isVerified, LocalDate verifiedDate,
			int employerId) {
		super(id, activationCode, isVerified, verifiedDate);
		this.employerId = employerId;
	}

	public int getEmployerId() {
		return employerId;
	}

	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}

}
