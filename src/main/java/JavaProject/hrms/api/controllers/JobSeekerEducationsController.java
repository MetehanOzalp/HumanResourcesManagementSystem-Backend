package JavaProject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.JobSeekerEducationService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.JobSeekerEducation;

@RestController
@RequestMapping("/api/jobSeeerEducations/")
@CrossOrigin
public class JobSeekerEducationsController {

	private JobSeekerEducationService jobSeekerEducationService;

	@Autowired
	public JobSeekerEducationsController(JobSeekerEducationService jobSeekerEducationService) {
		super();
		this.jobSeekerEducationService = jobSeekerEducationService;
	}

	@PostMapping("add")
	public Result add(@RequestBody JobSeekerEducation jobSeekerEducation) {
		return jobSeekerEducationService.add(jobSeekerEducation);
	}

	@GetMapping("getByDateOfGraduationSorted")
	public DataResult<List<JobSeekerEducation>> getByDateOfGraduationSorted(@RequestParam int jobSeekerId) {
		return jobSeekerEducationService.getByDateOfGraduationSorted(jobSeekerId);
	}

}
