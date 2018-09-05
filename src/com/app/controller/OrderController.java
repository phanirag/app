package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Order;
import com.app.service.IOrderService;

@Controller
public class OrderController {
	
	@Autowired
	private IOrderService service;
	
	@RequestMapping(value="/viewAllOrder")
	public String showallOrder(ModelMap map){
		List<Order> Orderlist=service.getAllOrder();
		map.addAttribute("list",Orderlist);
		return "OrderData";
	}
	@RequestMapping(value="/updateOrderID")
	public String showupdateid(@RequestParam("OrderId")int id,ModelMap map){
		Order Order=service.getOrderById(id);
		map.addAttribute("Orderobj",Order);
		return "OrderUpdate";
	}
	
	@RequestMapping(value="/updateOrder",method=RequestMethod.POST)
	public String updateOrder(@ModelAttribute("Order")Order Order){
		service.updateOrder(Order);
		return "redirect:viewAllOrder";
	}
	
	@RequestMapping(value="/deleteOrder")
	public String deleteItem(@RequestParam("OrderId")int id){
		service.deleteOrder(id);
		return "redirect:viewAllOrder";
	}
	
	@RequestMapping(value="/Orderexeclexport")
	public String showExcelData(ModelMap map){
		List<Order> Order=service.getAllOrder();
		map.addAttribute("Order",Order);
		return "OrderExcelView";
	}
	
	@RequestMapping(value="/Orderpdfexport")
	public String showPdfData(ModelMap map){
		List<Order> Order=service.getAllOrder();
		map.addAttribute("Order",Order);
		return "OrderPdfView";
	}

}
