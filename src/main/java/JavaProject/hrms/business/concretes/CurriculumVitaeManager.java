package JavaProject.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.CurriculumVitaeService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.core.utilities.results.SuccessDataResult;
import JavaProject.hrms.core.utilities.results.SuccessResult;
import JavaProject.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import JavaProject.hrms.entities.concretes.CurriculumVitae;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

	private CurriculumVitaeDao curriculumVitaeDao;

	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		curriculumVitae.setCreatedDate(LocalDate.now());
		curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("CV eklendi");
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CurriculumVitae>>(curriculumVitaeDao.findAll(), "CV'ler listelendi");
	}

	@Override
	public DataResult<List<CurriculumVitae>> getByJobSeekerId(int id) {
		return new SuccessDataResult<List<CurriculumVitae>>(curriculumVitaeDao.getByJobSeeker_id(id),
				"Kullanıcıya ait CV'ler listelendi");
	}

}
