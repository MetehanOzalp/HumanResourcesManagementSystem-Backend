package JavaProject.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import JavaProject.hrms.business.abstracts.CurriculumVitaeService;
import JavaProject.hrms.core.adapters.image.CloudinaryManager;
import JavaProject.hrms.core.adapters.image.ImageService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.ErrorDataResult;
import JavaProject.hrms.core.utilities.results.ErrorResult;
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
	public Result imageAdd(int id, MultipartFile file) {
		var result = getById(id);
		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		ImageService imageService = new CloudinaryManager();
		Map<String, String> upload = (Map<String, String>) imageService.uploadImage(file).getData();
		result.getData().setImagePath(upload.get("url"));
		curriculumVitaeDao.save(result.getData());
		return new SuccessResult("Resim yüklendi");
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

	@Override
	public DataResult<CurriculumVitae> getById(int id) {
		var result = curriculumVitaeDao.findById(id).get();
		if (result == null) {
			return new ErrorDataResult<CurriculumVitae>("Böyle bir CV bulunamadı");
		}
		return new SuccessDataResult<CurriculumVitae>(result);
	}

}
