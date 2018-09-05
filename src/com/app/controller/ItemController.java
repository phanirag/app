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

import com.app.model.Item;
import com.app.service.IItemService;

@Controller
public class ItemController {

	@Autowired
	private IItemService service;

	@Autowired
	private ServletContext context;
	
	@RequestMapping("/regItem")
	public String showPage(){
		return "ItemReg";
	}
	
	@RequestMapping(value="/insertItem",method=RequestMethod.POST)
	public String saveItem(@ModelAttribute("item")Item Item,ModelMap map){
		int Itemid=service.saveItem(Item);
		String message="Record id"+Itemid;
		map.addAttribute("msg",message);
		return "ItemReg";
	}
	
	@RequestMapping(value="/viewAllItem")
	public String showallItem(ModelMap map){
		List<Item> Itemlist=service.getallItem();
		map.addAttribute("list",Itemlist);
		return "ItemData";
	}
	@RequestMapping(value="/updateID")
	public String showupdateid(@RequestParam("itemId")int id,ModelMap map){
		Item Item=service.getItembyid(id);
		map.addAttribute("Itemobj",Item);
		return "ItemUpdate";
	}
	
	@RequestMapping(value="/updateItem",method=RequestMethod.POST)
	public String updateItem(@ModelAttribute("Item")Item Item){
		service.updateItem(Item);
		return "redirect:viewAllItem";
	}
	
	@RequestMapping(value="/deleteItem")
	public String deleteItem(@RequestParam("itemId")int id){
		service.deleteItem(id);
		return "redirect:viewAllItem";
	}
	
	@RequestMapping(value="/Itemexeclexport")
	public String showExcelData(ModelMap map){
		List<Item> Item=service.getallItem();
		map.addAttribute("Item",Item);
		return "ItemExcelView";
	}
	
	@RequestMapping(value="/Itempdfexport")
	public String showPdfData(ModelMap map){
		List<Item> Item=service.getallItem();
		map.addAttribute("Item",Item);
		return "ItemPdfView";
	}

}
