package JavaProject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.JobPostingService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
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
	public Result add(@RequestBody JobPosting jobPosting) {
		return jobPostingService.add(jobPosting);
	}

	@PostMapping("delete")
	public Result delete(@RequestParam int jobPostingId) {
		return jobPostingService.delete(jobPostingId);
	}

	@PostMapping("changeStatus")
	public Result changeStatus(@RequestParam int jobPostingId) {
		return jobPostingService.changeJobPostingStatus(jobPostingId);
	}

	@GetMapping("getByActive")
	public Result getByActive() {
		return jobPostingService.getByActiveOrPassiveJobPostings(true);
	}

	@GetMapping("getByActiveAndPageable")
	public Result getByActiveAndPageable(@RequestParam int pageNumber) {
		return jobPostingService.getByIsConfirmAndPageNumber(true, pageNumber);
	}

	@PostMapping("getByActiveAndFilter")
	@ResponseBody
	public Result getByActiveAndFilter(@RequestParam int pageNumber, @RequestBody JobPostingFilter jobPostingFilter) {
		return jobPostingService.getByIsConfirmAndPageNumberAndFilter(true, pageNumber, jobPostingFilter);
	}

	@GetMapping("getByPassive")
	public Result getByPassive() {
		return jobPostingService.getByActiveOrPassiveJobPostings(false);
	}

	@GetMapping("getByReleaseDate")
	public DataResult<List<JobPosting>> getByReleaseDate(@RequestParam int value) {
		return jobPostingService.getByReleaseDateJobPosting(value);
	}

	@GetMapping("getByEmployer")
	public DataResult<List<JobPosting>> getByEmployer(@RequestParam int employerId) {
		return jobPostingService.getByEmployerJobPosting(employerId);
	}

	@GetMapping("getById")
	public Result getById(@RequestParam int id) {
		return jobPostingService.getByJobPostingId(id);
	}

}
