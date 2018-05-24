package com.samtec.location.controller;

import java.util.List;


import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.samtec.location.entities.Location;
import com.samtec.location.repos.LocationRepository;
import com.samtec.location.service.LocationService;
import com.samtec.location.util.EmailUtil;
import com.samtec.location.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	LocationService locationservice;
	
	@Autowired 
	LocationRepository repository;
	
	@Autowired
	ReportUtil reportUtil;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	ServletContext sc;

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}

	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {

		Location location_ = locationservice.saveLocation(location);
		String message = "Location save succfully  :   " + location_.toString();
		modelMap.addAttribute("msg", message);
		emailUtil.sendMail("samelabd@gmail.com", "Location *******", location.toString());
		return "createLocation";
	}

	@RequestMapping("/displayLocations")
	public String showLocations(ModelMap modelMap) {
		List<Location> locations = locationservice.getAllLocation();

		modelMap.addAttribute("locations", locations);

		return "showLocations";
	}
	
	
	@RequestMapping("/deleteLoc")
	public String deleteLocation(@RequestParam("id") int id,ModelMap modelMap) {
		Location location = locationservice.getLocationById(id);
		locationservice.deleteLocation(location);
		
		
		List<Location> locations = locationservice.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "showLocations";
	}
	
	
	@RequestMapping("/updateLoc")
	public String showUpdateLocation(@RequestParam("id")int id,ModelMap modelMap)
	{
		Location location = locationservice.getLocationById(id);
		modelMap.addAttribute("location_", location);
		
		return "editLocation";
	}
	
	@RequestMapping("/showupdatedLocation")
	public String updateLocation(@ModelAttribute("location")Location location , ModelMap modelMap) {
		
		locationservice.updateLocation(location);
		
		List<Location> locations = locationservice.getAllLocation();
		modelMap.addAttribute("locations", locations);
		
		return "showLocations";
	}
	
	
	@RequestMapping("/generateReport")
	public String generateReport() {
		
		String path = sc.getRealPath("/");
		System.out.println("before execute findTypeAndTypeCount() *******************######################");
		List<Object[]> data = repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		return "report";
	}
	
	
	
	
}
