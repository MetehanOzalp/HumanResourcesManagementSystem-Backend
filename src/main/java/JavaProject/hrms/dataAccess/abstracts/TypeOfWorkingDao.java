package JavaProject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import JavaProject.hrms.entities.concretes.TypeOfWorking;

public interface TypeOfWorkingDao extends JpaRepository<TypeOfWorking, Integer> {

}
