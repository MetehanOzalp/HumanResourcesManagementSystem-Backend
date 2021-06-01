package JavaProject.hrms.entities.concretes;

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
@Table(name = "job_seeker_foreign_languages")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "curriculumVitae" })
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerForeignLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "curriculum_vitaes_id")
	private CurriculumVitae curriculumVitae;

	@Column(name = "language_name")
	private String languageName;

	@Column(name = "language_level")
	private int languageLevel;

}
