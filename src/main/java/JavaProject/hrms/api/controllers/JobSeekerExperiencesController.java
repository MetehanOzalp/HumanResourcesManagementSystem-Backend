package JavaProject.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.JobSeekerExperienceService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.JobSeekerExperience;

@RestController
@RequestMapping("/api/jobExperiences/")
@CrossOrigin
public class JobSeekerExperiencesController {

	private JobSeekerExperienceService jobSeekerExperienceService;

	public JobSeekerExperiencesController(JobSeekerExperienceService jobSeekerExperienceService) {
		super();
		this.jobSeekerExperienceService = jobSeekerExperienceService;
	}

	@PostMapping("add")
	public Result add(@RequestBody JobSeekerExperience jobSeekerExperience) {
		return jobSeekerExperienceService.add(jobSeekerExperience);
	}

	@PutMapping("update")
	public Result update(@RequestBody JobSeekerExperience jobSeekerExperience) {
		return jobSeekerExperienceService.update(jobSeekerExperience);
	}

	@DeleteMapping("delete")
	public Result delete(@RequestParam int id) {
		return jobSeekerExperienceService.delete(id);
	}

	@GetMapping("getByDateOfFinishSorted")
	public DataResult<List<JobSeekerExperience>> getByDateOfFinishSorted(@RequestParam int jobSeekerId) {
		return jobSeekerExperienceService.getByDateOfFinishSorted(jobSeekerId);
	}

}
