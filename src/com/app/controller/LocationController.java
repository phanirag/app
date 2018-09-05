package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Location;
import com.app.service.ILocationService;
import com.app.util.LocationUtil;

@Controller
public class LocationController {
	@Autowired
	private ILocationService service;
	@Autowired
	private LocationUtil util;
	@Autowired
	private ServletContext context;
	
	
	//1. To show Register Page
	@RequestMapping("/regLoc")
	public String showPage(){
		return "LocationReg";
	}
	//2. to save data in DB
	@RequestMapping(value="/insertLoc",method=RequestMethod.POST)
	public String saveLocation(@ModelAttribute("location")Location loc,ModelMap map){
		int locId=service.saveLocation(loc);
		String message="Location saved with id:"+locId;
		map.addAttribute("msg",message);
		return "LocationReg";
	}
	
	//3. Get Data from DB and show at UI
	@RequestMapping("/viewAllLocs")
	public String getAllLocs(ModelMap map){
		List<Location> locs=service.getAllLocations();
		map.addAttribute("locations", locs);
		return "LocationData";
	}

	
	//4. delete row
	@RequestMapping("/deleteLoc")
	public String deleteLocation(
			@RequestParam("locId")int locId
	)
	{
		service.deleteLocation(locId);
		return "redirect:viewAllLocs";
	}
	
	//5. show Edit Page
	@RequestMapping("/editLoc")
	public String showLocEdit(@RequestParam("locId")int locId,ModelMap map){
		Location location=service.getLocationById(locId);
		map.addAttribute("loc",location);
		return "LocationDataEdit";
	}
	
	//6. Update Location obj
	@RequestMapping(value="/updateLoc",method=RequestMethod.POST)
	public String updateLocation(@ModelAttribute("location")Location loc){
		service.updateLocation(loc);
		return "redirect:viewAllLocs";
	}
	
	//7. Excel Export
	@RequestMapping("/locExcelExport")
	public String showExcelData(ModelMap map){
		List<Location> locs=service.getAllLocations();
		map.addAttribute("locs",locs);
		return "locExcelView";
	}
	
	//8. PDF Export
	@RequestMapping("/locPdfExport")
	public String showPdfData(ModelMap map){
		List<Location> locs=service.getAllLocations();
		map.addAttribute("locs", locs);
		return "locPdfView";
	}
	
	//9. Show Location Charts
	@RequestMapping("/showLocReports")
	public String generateReports(){
		List<Object[]> list=service.getLocationTypeCount();
		String path=context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBarChart(path, list);
		return "LocationReports";
	}
	
}





