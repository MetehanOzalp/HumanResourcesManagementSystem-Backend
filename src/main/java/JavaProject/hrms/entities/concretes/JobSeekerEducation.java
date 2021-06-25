package JavaProject.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_seeker_educations")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "curriculumVitae" })
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerEducation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "curriculum_vitaes_id", insertable = false, updatable = false)
	private CurriculumVitae curriculumVitae;

	@Column(name = "curriculum_vitaes_id")
	private int cvId;

	@Column(name = "school_name")
	private String schoolName;

	@Column(name = "field_of_study")
	private String fieldOfStudy;

	@Column(name = "degree")
	private String degree;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

}
