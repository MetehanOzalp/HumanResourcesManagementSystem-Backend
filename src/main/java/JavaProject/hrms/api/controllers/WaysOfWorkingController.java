package JavaProject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.WayOfWorkingService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.WayOfWorking;

@RestController
@RequestMapping("/api/waysOfWorking/")
@CrossOrigin
public class WaysOfWorkingController {

	private WayOfWorkingService wayOfWorkingService;

	@Autowired
	public WaysOfWorkingController(WayOfWorkingService wayOfWorkingService) {
		super();
		this.wayOfWorkingService = wayOfWorkingService;
	}

	@PostMapping("add")
	public Result add(WayOfWorking wayOfWorking) {
		return wayOfWorkingService.add(wayOfWorking);
	}

	@GetMapping("getAll")
	public DataResult<List<WayOfWorking>> getAll() {
		return wayOfWorkingService.getAll();
	}

}
