package JavaProject.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.FavoriteService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.Favorite;

@RestController
@RequestMapping("/api/favorites/")
@CrossOrigin
public class FavoritesController {

	private FavoriteService favoriteService;

	public FavoritesController(FavoriteService favoriteService) {
		super();
		this.favoriteService = favoriteService;
	}

	@PostMapping("add")
	public Result add(@RequestBody Favorite favorite) {
		return favoriteService.add(favorite);
	}

	@DeleteMapping("delete")
	public Result delete(@RequestParam int id) {
		return favoriteService.delete(id);
	}

	@GetMapping("getByJobSeekerId")
	public DataResult<List<Favorite>> getByJobSeekerId(@RequestParam int id) {
		return favoriteService.getByJobSeekerId(id);
	}

}
