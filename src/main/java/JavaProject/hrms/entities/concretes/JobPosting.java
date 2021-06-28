package JavaProject.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_postings")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "job_description")
	private String jobDescription;

	@Column(name = "min_salary")
	private int minSalary;

	@Column(name = "max_salary")
	private int maxSalary;

	@Column(name = "open_position_count")
	private int openPositionCount;

	@Column(name = "application_deadline")
	private LocalDate applicationDeadline;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "release_date")
	private LocalDate releaseDate;

	@Column(name = "type_of_working_id")
	private int typeOfWorkingId;

	@Column(name = "way_of_working_id")
	private int wayOfWorkingId;

	@Column(name = "employer_id")
	private int employerId;

	@Column(name = "job_position_id")
	private int jobPositionId;

	@Column(name = "city_id")
	private int cityId;

	@ManyToOne()
	@JoinColumn(name = "type_of_working_id", insertable = false, updatable = false)
	private TypeOfWorking typeOfWorking;

	@ManyToOne
	@JoinColumn(name = "way_of_working_id", insertable = false, updatable = false)
	private WayOfWorking wayOfWorking;

	@ManyToOne()
	@JoinColumn(name = "employer_id", insertable = false, updatable = false)
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name = "job_position_id", insertable = false, updatable = false)
	private JobPosition jobPosition;

	@ManyToOne
	@JoinColumn(name = "city_id", insertable = false, updatable = false)
	private City city;

	@OneToMany(mappedBy = "jobSeeker")
	private List<Favorite> favorites;
	
}
