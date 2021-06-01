package JavaProject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import JavaProject.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer> {

}
