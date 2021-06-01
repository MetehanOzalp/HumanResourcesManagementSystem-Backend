package JavaProject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.JobSeekerForeignLanguageService;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.JobSeekerForeignLanguage;

@RestController
@RequestMapping("/api/jobSeekerForeignLanguages/")
public class JobSeekerForeignLanguagesController {

	private JobSeekerForeignLanguageService jobSeekerForeignLanguageService;

	@Autowired
	public JobSeekerForeignLanguagesController(JobSeekerForeignLanguageService jobSeekerForeignLanguageService) {
		super();
		this.jobSeekerForeignLanguageService = jobSeekerForeignLanguageService;
	}

	@PostMapping("add")
	public Result add(JobSeekerForeignLanguage jobSeekerForeignLanguage) {
		return jobSeekerForeignLanguageService.add(jobSeekerForeignLanguage);
	}

}
