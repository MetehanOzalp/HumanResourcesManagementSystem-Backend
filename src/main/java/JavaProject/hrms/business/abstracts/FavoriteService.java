package JavaProject.hrms.business.abstracts;

import java.util.List;

import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.Favorite;

public interface FavoriteService {

	Result add(Favorite favorite);

	Result delete(int id);

	DataResult<List<Favorite>> getByJobSeekerId(int id);

}
