package JavaProject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.JobPostingService;
import JavaProject.hrms.entities.concretes.JobPosting;
import JavaProject.hrms.entities.dtos.JobPostingFilter;

@RestController
@RequestMapping("api/jobPosting/")
@CrossOrigin
public class JobPostingsController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingsController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody JobPosting jobPosting) {
		var result = jobPostingService.add(jobPosting);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

	@PostMapping("delete")
	public ResponseEntity<?> delete(@RequestParam int jobPostingId) {
		var result = jobPostingService.delete(jobPostingId);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

	@PostMapping("changeStatus")
	public ResponseEntity<?> changeStatus(@RequestParam int jobPostingId) {
		var result = jobPostingService.changeJobPostingStatus(jobPostingId);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

	@GetMapping("getByActive")
	public ResponseEntity<?> getByActive() {
		var result = jobPostingService.getByActiveOrPassiveJobPostings(true);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

	@GetMapping("getByActiveAndPageable")
	public ResponseEntity<?> getByActiveAndPageable(@RequestParam int pageNumber) {
		var result = jobPostingService.getByIsConfirmAndPageNumber(true, pageNumber);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

	@PostMapping("getByActiveAndFilter")
	@ResponseBody
	public ResponseEntity<?> getByActiveAndFilter(@RequestParam int pageNumber,
			@RequestBody JobPostingFilter jobPostingFilter) {
		var result = jobPostingService.getByIsConfirmAndPageNumberAndFilter(true, pageNumber, jobPostingFilter);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

	@GetMapping("getByPassive")
	public ResponseEntity<?> getByPassive() {
		var result = jobPostingService.getByActiveOrPassiveJobPostings(false);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

	@GetMapping("getByReleaseDate")
	public ResponseEntity<?> getByReleaseDate(@RequestParam int value) {
		var result = jobPostingService.getByReleaseDateJobPosting(value);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

	@GetMapping("getByEmployer")
	public ResponseEntity<?> getByEmployer(@RequestParam int employerId) {
		var result = jobPostingService.getByEmployerJobPosting(employerId);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

	@GetMapping("getById")
	public ResponseEntity<?> getById(@RequestParam int id) {
		var result = jobPostingService.getByJobPostingId(id);
		if (!result.isSuccess()) {
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}

}
