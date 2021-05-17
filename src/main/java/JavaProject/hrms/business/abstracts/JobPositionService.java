package JavaProject.hrms.business.abstracts;

import java.util.List;

import JavaProject.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
}
