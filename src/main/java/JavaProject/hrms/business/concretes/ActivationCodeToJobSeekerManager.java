package JavaProject.hrms.business.concretes;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.ActivationCodeToJobSeekerService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.ErrorDataResult;
import JavaProject.hrms.core.utilities.results.ErrorResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.core.utilities.results.SuccessDataResult;
import JavaProject.hrms.core.utilities.results.SuccessResult;
import JavaProject.hrms.dataAccess.abstracts.ActivationCodeToJobSeekerDao;
import JavaProject.hrms.entities.concretes.ActivationCodeToJobSeeker;

@Service
public class ActivationCodeToJobSeekerManager implements ActivationCodeToJobSeekerService {

	private ActivationCodeToJobSeekerDao activationCodeToJobSeekerDao;

	public ActivationCodeToJobSeekerManager(ActivationCodeToJobSeekerDao activationCodeToJobSeekerDao) {
		super();
		this.activationCodeToJobSeekerDao = activationCodeToJobSeekerDao;
	}

	@Override
	public Result add(ActivationCodeToJobSeeker activationCodeToJobSeeker) {
		activationCodeToJobSeekerDao.save(activationCodeToJobSeeker);
		return new SuccessResult("Aktivasyon kodu eklendi");
	}

	@Override
	public Result verify(String code) {
		String[] parse = code.split("-");
		var result = getByJobSeekerId(Integer.parseInt(parse[1]));
		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		if (!result.getData().getActivationCode().equals(code)) {
			return new ErrorResult("Doğrulama başarısız");
		}
		result.getData().setVerified(true);
		result.getData().setVerifiedDate(LocalDate.now());
		activationCodeToJobSeekerDao.save(result.getData());
		return new SuccessResult("Doğrulama başarılı");
	}

	@Override
	public DataResult<ActivationCodeToJobSeeker> getByJobSeekerId(int id) {
		var result = activationCodeToJobSeekerDao.getByJobSeekerId(id);
		if (result == null) {
			return new ErrorDataResult<ActivationCodeToJobSeeker>("Kullanıcıya ait kod bulunamadı");
		}
		return new SuccessDataResult<ActivationCodeToJobSeeker>(result);
	}

}
