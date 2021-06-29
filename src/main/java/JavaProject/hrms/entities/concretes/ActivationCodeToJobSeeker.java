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
@Table(name = "activation_code_to_job_seekers")
@PrimaryKeyJoinColumn(name = "id")
@NoArgsConstructor
public class ActivationCodeToJobSeeker extends ActivationCode {

	@Column(name = "job_seeker_id")
	private int jobSeekerId;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "job_seeker_id", nullable = false, insertable = false, updatable = false)
	private JobSeeker jobSeeker;

	public ActivationCodeToJobSeeker(int id, String activationCode, boolean isVerified, LocalDate verifiedDate,
			int jobSeekerId) {
		super(id, activationCode, isVerified, verifiedDate);
		this.jobSeekerId = jobSeekerId;
	}

	public int getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(int jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

}
