package JavaProject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import JavaProject.hrms.entities.concretes.JobSeekerForeignLanguage;

public interface JobSeekerForeignLanguageDao extends JpaRepository<JobSeekerForeignLanguage, Integer> {

}
