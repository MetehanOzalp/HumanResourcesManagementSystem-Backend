package JavaProject.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import JavaProject.hrms.business.abstracts.FavoriteService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.core.utilities.results.SuccessDataResult;
import JavaProject.hrms.core.utilities.results.SuccessResult;
import JavaProject.hrms.dataAccess.abstracts.FavoriteDao;
import JavaProject.hrms.entities.concretes.Favorite;

@Service
public class FavoriteManager implements FavoriteService {

	private FavoriteDao favoriteDao;

	public FavoriteManager(FavoriteDao favoriteDao) {
		super();
		this.favoriteDao = favoriteDao;
	}

	@Override
	public Result add(Favorite favorite) {
		favoriteDao.save(favorite);
		return new SuccessResult("Favorilere eklendi");
	}

	@Override
	public Result delete(int id) {
		favoriteDao.deleteById(id);
		return new SuccessResult("Favorilerden silindi");
	}

	@Override
	public DataResult<List<Favorite>> getByJobSeekerId(int id) {
		return new SuccessDataResult<List<Favorite>>(favoriteDao.getByJobSeeker_Id(id));
	}

}
