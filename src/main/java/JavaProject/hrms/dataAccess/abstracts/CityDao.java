package JavaProject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import JavaProject.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {

}
