package JavaProject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.JobPostingService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("api/jobPosting/")
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

	@PostMapping("changeStatus")
	public Result changeStatus(@RequestParam int jobPostingId) {
		return jobPostingService.changeJobPostingStatus(jobPostingId);
	}

	@GetMapping("getByActive")
	public Result getByActive() {
		return jobPostingService.getByActiveJobPostings();
	}

	@GetMapping("getByReleaseDate")
	public DataResult<List<JobPosting>> getByReleaseDate(@RequestParam int value) {
		return jobPostingService.getByReleaseDateJobPosting(value);
	}

	@GetMapping("getByEmployer")
	public DataResult<List<JobPosting>> getByEmployer(@RequestParam int employerId) {
		return jobPostingService.getByEmployerJobPosting(employerId);
	}

}
