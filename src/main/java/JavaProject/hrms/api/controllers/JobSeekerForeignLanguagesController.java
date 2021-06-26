package JavaProject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.JobSeekerForeignLanguageService;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.JobSeekerForeignLanguage;

@RestController
@RequestMapping("/api/jobSeekerForeignLanguages/")
@CrossOrigin
public class JobSeekerForeignLanguagesController {

	private JobSeekerForeignLanguageService jobSeekerForeignLanguageService;

	@Autowired
	public JobSeekerForeignLanguagesController(JobSeekerForeignLanguageService jobSeekerForeignLanguageService) {
		super();
		this.jobSeekerForeignLanguageService = jobSeekerForeignLanguageService;
	}

	@PostMapping("add")
	public Result add(@RequestBody JobSeekerForeignLanguage jobSeekerForeignLanguage) {
		return jobSeekerForeignLanguageService.add(jobSeekerForeignLanguage);
	}

	@PutMapping("update")
	public Result update(@RequestBody JobSeekerForeignLanguage jobSeekerForeignLanguage) {
		return jobSeekerForeignLanguageService.update(jobSeekerForeignLanguage);
	}

	@DeleteMapping("delete")
	public Result delete(@RequestParam int id) {
		return jobSeekerForeignLanguageService.delete(id);
	}

}
