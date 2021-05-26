package JavaProject.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "employer_activation_by_employees")
@NoArgsConstructor
public class EmployerActivationByEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "employer_id")
	private int employerId;

	@Column(name = "employee_id")
	private int employeeId;

	@Column(name = "is_verified")
	private boolean isVerified;

	@Column(name = "verified_date", columnDefinition = "Date default CURRENT_DATE")
	private LocalDate verifiedDate;

	public EmployerActivationByEmployee(int id, int employerId, int employeeId, boolean isVerified,
			LocalDate verifiedDate) {
		super();
		this.id = id;
		this.employerId = employerId;
		this.employeeId = employeeId;
		this.isVerified = isVerified;
		this.verifiedDate = verifiedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployerId() {
		return employerId;
	}

	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public LocalDate getVerifiedDate() {
		return verifiedDate;
	}

	public void setVerifiedDate(LocalDate verifiedDate) {
		this.verifiedDate = verifiedDate;
	}

}
