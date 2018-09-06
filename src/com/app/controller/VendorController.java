package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.util.VendorUtil;

@Controller
public class VendorController {
	@Autowired
	private IVendorService service;
	@Autowired
	private VendorUtil util;
	@Autowired
	private ServletContext context;
	
	
	//1. To show Register Page
	@RequestMapping("/regVen")
	public String showPage(ModelMap model){
		model.addAttribute("vendor",new Vendor());
		return "VendorReg";
	}
	//2. to save data in DB
	@RequestMapping(value="/insertVen",method=RequestMethod.POST)
	public String saveVendor(@Valid @ModelAttribute("vendor")Vendor vendor,BindingResult r,ModelMap map){
		
		if(r.hasErrors()){
			return "VendorReg";
		}
		
		int venId=service.saveVendor(vendor);
		String message="Vendor saved with id:"+venId;
		map.addAttribute("msg",message);
		return "VendorReg";
	}
	
	//3. Get Data from DB and show at UI
	@RequestMapping("/viewAllVens")
	public String getAllVens(ModelMap map){
		List<Vendor> vens=service.getAllVendors();
		map.addAttribute("vendors", vens);
		return "VendorData";
	}

	
	//4. delete row
	@RequestMapping("/deleteVen")
	public String deleteVendor(
			@RequestParam("venId")int venId
	)
	{
		service.deleteVendor(venId);
		return "redirect:viewAllVens";
	}
	
	//5. show Edit Page
	@RequestMapping("/editVen")
	public String showVenEdit(@RequestParam("venId")int venId,ModelMap map){
		Vendor ven=service.getVendorById(venId);
		map.addAttribute("ven",ven);
		util.addUiComponents(map);
		return "VendorDataEdit";
	}
	
	//6. Update Vendor obj
	@RequestMapping(value="/updateVen",method=RequestMethod.POST)
	public String updateVendor(@ModelAttribute("vendor")Vendor ven){
		service.updateVendor(ven);
		return "redirect:viewAllVens";
	}
	
	//7. Excel Export
	@RequestMapping("/venExcelExport")
	public String showExcelData(ModelMap map){
		List<Vendor> vens=service.getAllVendors();
		map.addAttribute("vens",vens);
		return "venExcelView";
	}
	
	//8. PDF Export
	@RequestMapping("/venPdfExport")
	public String showPdfData(ModelMap map){
		List<Vendor> vens=service.getAllVendors();
		map.addAttribute("vens", vens);
		return "venPdfView";
	}
	
	//9. Show Vendor Charts
	@RequestMapping("/showVenReports")
	public String generateReports(){
		List<Object[]> list=service.getLocationTypeCount();
		String path=context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);;
		return "VendorReports";
	}
	
}