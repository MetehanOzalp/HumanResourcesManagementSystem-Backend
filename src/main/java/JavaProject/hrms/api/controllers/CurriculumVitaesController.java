package JavaProject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import JavaProject.hrms.business.abstracts.CurriculumVitaeService;
import JavaProject.hrms.entities.concretes.CurriculumVitae;

@RestController
@RequestMapping("/api/curriculumVitaes/")
@CrossOrigin
public class CurriculumVitaesController {

	private CurriculumVitaeService curriculumVitaeService;

	@Autowired
	public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
		super();
		this.curriculumVitaeService = curriculumVitaeService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody CurriculumVitae curriculumVitae) {
		var result = curriculumVitaeService.add(curriculumVitae);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

	@PostMapping("imageAdd")
	public ResponseEntity<?> imageAdd(@RequestParam int curriculumVitaeId, @RequestParam MultipartFile file) {
		var result = curriculumVitaeService.imageAdd(curriculumVitaeId, file);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

	@PutMapping("imageUpdate")
	public ResponseEntity<?> imageUpdate(@RequestParam int curriculumVitaeId, @RequestBody MultipartFile file) {
		var result = curriculumVitaeService.imageUpdate(curriculumVitaeId, file);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

	@GetMapping("getAll")
	public ResponseEntity<?> getAll() {
		var result = curriculumVitaeService.getAll();
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

	@GetMapping("getByJobSeekerId")
	public ResponseEntity<?> getByJobSeekerId(@RequestParam int getByJobSeekerId) {
		var result = curriculumVitaeService.getByJobSeekerId(getByJobSeekerId);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

}
