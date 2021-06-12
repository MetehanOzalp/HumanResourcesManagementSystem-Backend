package JavaProject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JavaProject.hrms.business.abstracts.CityService;
import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities/")
@CrossOrigin
public class CitiesController {

	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}

	@GetMapping("getAll")
	public DataResult<List<City>> getAll() {
		return cityService.getAll();
	}

}
