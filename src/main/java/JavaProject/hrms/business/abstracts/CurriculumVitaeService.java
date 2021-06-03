package JavaProject.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {

	Result add(CurriculumVitae curriculumVitae);

	Result imageAdd(int id, MultipartFile file);

	DataResult<List<CurriculumVitae>> getAll();

	DataResult<List<CurriculumVitae>> getByJobSeekerId(int id);

	DataResult<CurriculumVitae> getById(int id);

}
