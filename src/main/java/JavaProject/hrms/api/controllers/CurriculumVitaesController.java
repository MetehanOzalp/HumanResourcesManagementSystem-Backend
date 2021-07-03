package JavaProject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
import JavaProject.hrms.core.utilities.results.Result;
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
	public Result add(@RequestBody CurriculumVitae curriculumVitae) {
		return curriculumVitaeService.add(curriculumVitae);
	}

	@PostMapping("imageAdd")
	public Result imageAdd(@RequestParam int curriculumVitaeId, @RequestParam MultipartFile file) {
		return curriculumVitaeService.imageAdd(curriculumVitaeId, file);
	}

	@PutMapping("imageUpdate")
	public Result imageUpdate(@RequestBody MultipartFile file) {
		return curriculumVitaeService.imageUpdate(1, file);
	}

	@GetMapping("getAll")
	public Result getAll() {
		return curriculumVitaeService.getAll();
	}

	@GetMapping("getByJobSeekerId")
	public Result getByJobSeekerId(@RequestParam int getByJobSeekerId) {
		return curriculumVitaeService.getByJobSeekerId(getByJobSeekerId);
	}

}
