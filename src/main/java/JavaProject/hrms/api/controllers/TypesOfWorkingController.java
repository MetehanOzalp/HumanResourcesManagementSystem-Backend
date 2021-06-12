package JavaProject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.TypeOfWorkingService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.Result;
import JavaProject.hrms.entities.concretes.TypeOfWorking;

@RestController
@RequestMapping("/api/typesOfWorking/")
@CrossOrigin
public class TypesOfWorkingController {

	private TypeOfWorkingService typeOfWorkingService;

	@Autowired
	public TypesOfWorkingController(TypeOfWorkingService typeOfWorkingService) {
		super();
		this.typeOfWorkingService = typeOfWorkingService;
	}

	@PostMapping("add")
	public Result add(TypeOfWorking typeOfWorking) {
		return typeOfWorkingService.add(typeOfWorking);
	}

	@GetMapping("getAll")
	public DataResult<List<TypeOfWorking>> getAll() {
		return typeOfWorkingService.getAll();
	}

}
