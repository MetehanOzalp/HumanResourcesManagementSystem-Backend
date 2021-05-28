package JavaProject.hrms.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.ActivationCodeToEmployerService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.ErrorDataResult;
import JavaProject.hrms.core.utilities.results.ErrorResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.core.utilities.results.SuccessDataResult;
import JavaProject.hrms.core.utilities.results.SuccessResult;
import JavaProject.hrms.dataAccess.abstracts.ActivationCodeToEmployerDao;
import JavaProject.hrms.entities.concretes.ActivationCodeToEmployer;

@Service
public class ActivationCodeToEmployerManager implements ActivationCodeToEmployerService {

	private ActivationCodeToEmployerDao activationCodeToEmployerDao;

	@Autowired
	public ActivationCodeToEmployerManager(ActivationCodeToEmployerDao activationCodeToEmployerDao) {
		super();
		this.activationCodeToEmployerDao = activationCodeToEmployerDao;
	}

	@Override
	public Result add(ActivationCodeToEmployer activationCodeToEmployer) {
		activationCodeToEmployerDao.save(activationCodeToEmployer);
		return new SuccessResult("Aktivasyon kodu eklendi");
	}

	@Override
	public Result verify(String code) {
		String[] parse = code.split("-");
		var result = getByEmployerId(Integer.parseInt(parse[1]));
		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		if (!result.getData().getActivationCode().equals(code)) {
			return new ErrorResult("Doğrulama geçersiz");
		}
		result.getData().setVerified(true);
		result.getData().setVerifiedDate(LocalDate.now());
		activationCodeToEmployerDao.save(result.getData());
		return new SuccessResult("Doğrulama başarılı");
	}

	public DataResult<ActivationCodeToEmployer> getByEmployerId(int id) {
		var result = activationCodeToEmployerDao.getByEmployerId(id);
		if (result == null) {
			return new ErrorDataResult<ActivationCodeToEmployer>("Kullanıcıya ait kod bulunamadı");
		}
		return new SuccessDataResult<ActivationCodeToEmployer>(result);
	}

}
