package JavaProject.hrms.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.JobSeekerSkillService;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.JobSeekerSkill;

@RestController
@RequestMapping("/api/jobSeekerSkills/")
public class JobSeekerSkillsController {

	private JobSeekerSkillService jobSeekerSkillService;

	public JobSeekerSkillsController(JobSeekerSkillService jobSeekerSkillService) {
		super();
		this.jobSeekerSkillService = jobSeekerSkillService;
	}

	@PostMapping("add")
	public Result add(@RequestBody JobSeekerSkill jobSeekerSkill) {
		return jobSeekerSkillService.add(jobSeekerSkill);
	}

}
