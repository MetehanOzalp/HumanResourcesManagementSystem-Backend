package JavaProject.hrms.business.abstracts;

import java.util.List;

import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {

	Result add(CurriculumVitae curriculumVitae);

	DataResult<List<CurriculumVitae>> getAll();

	DataResult<List<CurriculumVitae>> getByJobSeekerId(int id);

}
