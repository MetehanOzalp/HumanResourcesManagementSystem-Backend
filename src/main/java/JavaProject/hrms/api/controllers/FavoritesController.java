package JavaProject.hrms.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.FavoriteService;
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
	public ResponseEntity<?> add(@RequestBody Favorite favorite) {
		var result = favoriteService.add(favorite);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

	@DeleteMapping("delete")
	public ResponseEntity<?> delete(@RequestParam int id) {
		var result = favoriteService.delete(id);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

	@GetMapping("getByJobSeekerId")
	public ResponseEntity<?> getByJobSeekerId(@RequestParam int id) {
		var result = favoriteService.getByJobSeekerId(id);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

}
