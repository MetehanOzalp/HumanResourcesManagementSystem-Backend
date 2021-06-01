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
@Table(name = "curriculum_vitaes")
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitae {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;

	@Column(name = "image_path")
	private String imagePath;

	@Column(name = "github_link")
	private String githubLink;

	@Column(name = "linkedin_link")
	private String linkedinLink;

	@Column(name = "cover_letter")
	private String coverLetter;

	@Column(name = "created_date")
	private LocalDate createdDate;

	@OneToMany(mappedBy = "curriculumVitae")
	private List<JobSeekerEducation> jobSeekerEducations;

	@OneToMany(mappedBy = "curriculumVitae")
	private List<JobSeekerExperience> jobSeekerExperiences;

	@OneToMany(mappedBy = "curriculumVitae")
	private List<JobSeekerForeignLanguage> jobSeekerForeignLanguages;

	@OneToMany(mappedBy = "curriculumVitae")
	private List<JobSeekerSkill> jobSeekerSkills;

}
