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

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.util.CoDecUtil;
import com.app.util.CodeUtil;
import com.app.util.CommonUtil;
import com.app.util.CustomerUtil;

@Controller
public class CustomerController {
	
	@Autowired
	private ICustomerService service;

	@Autowired
	private CustomerUtil util;
	
	@Autowired
	private CommonUtil comutil;
	
	@Autowired
	private CodeUtil cUtil;
	
	@Autowired
	private CoDecUtil cdUtil;
	
	@Autowired
	private ServletContext context;
	
	@RequestMapping("/regCust")
	public String showPage(){
		return "CustomerReg";
	}
	
	@RequestMapping(value="/insertcust",method=RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer")Customer cust,ModelMap map){
		//generating pwd and token
		String pwd=cUtil.generatePwd();
		String token=cUtil.generateToken();
		
		//encoding pwd and token
		String epwd=cdUtil.genetareEncode(pwd);
		String etoken=cdUtil.genetareEncode(token);
		
		//saving to object
		cust.setPassword(epwd);
		cust.setAccToken(etoken);
		
		//sending Email
		String Subject="This is the test mail";
		 
		String text="The Username is:"+cust.getCustName()+
					"||Email Address:"+cust.getCustEmail()+
					"||Password for User:="+pwd+
					"||Token for User:="+token+
					"||Type of User :"+cust.getCustType();
		
	boolean flag=comutil.sendmail(cust.getCustEmail(), Subject, text);
		
		int custid=service.saveCustomer(cust);
		String message="Customer Saved With Id"+custid;

		if(flag)
			message+=",Email also sent successfully";
		else
			message+=",Email sending failed";

		//send message to UI
		map.addAttribute("msg", message);

		return "CustomerReg";
	}
	
	@RequestMapping(value="/viewAllcust")
	public String showallCustomer(ModelMap map){
		List<Customer> custlist=service.getallCustomer();
		map.addAttribute("list",custlist);	
		return "CustomerData";
	}
	@RequestMapping(value="/updatecust")
	public String showupdateid(@RequestParam("custId")int id,ModelMap map){
		Customer cust=service.getCustomerbyid(id);
		map.addAttribute("custObj",cust);
		return "CustomerUpdate";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/updateCustomer",method=RequestMethod.POST)
	public String updateCustomer(@ModelAttribute("customer")Customer cust){
		//generating pwd and token
				String pwd=cUtil.generatePwd();
				String token=cUtil.generateToken();
				
				//encoding pwd and token
				String epwd=cdUtil.genetareDecode(pwd);
				String etoken=cdUtil.genetareDecode(token);
				
				//saving to object
				cust.setPassword(epwd);
				cust.setAccToken(etoken);
				
		String Subject="This is an update Mail";
		String text="The Username is:"+cust.getCustName()+
				"||Email Address:"+cust.getCustEmail()+
				"||Password for User: "+cust.getPassword()+
				"||Token for User:"+cust.getAccToken()+
				"||Type of User :"+cust.getCustType();
		
		boolean flag=comutil.sendmail(cust.getCustEmail(), Subject, text);
		service.updateCustomer(cust);
		return "redirect:viewAllcust";
	}
	
	@RequestMapping(value="/deletecust")
	public String deleteCustomer(@RequestParam("custId")int id,ModelMap map){
		Customer cust=service.getCustomerbyid(id);
		
		comutil.sendmail(cust.getCustEmail(),"Account has been deleted"
				+ "","Your Account with Id"+cust.getCustId()+"Has been Removed From the Application");
		
		service.deleteCustomer(id);
		
		return "redirect:viewAllcust";
	}
	
	@RequestMapping(value="/custexeclexport")
	public String showExcelData(ModelMap map){
		List<Customer> cust=service.getallCustomer();
		map.addAttribute("cust",cust);
		return "custExcelView";
	}
	
	@RequestMapping(value="/custpdfexport")
	public String showPdfData(ModelMap map){
		List<Customer> cust=service.getallCustomer();
		map.addAttribute("cust",cust);
		return "custPdfView";
	}
	
	@RequestMapping(value="/showcustReports")
	public String generateReports(){
		List<Object[]> list=service.getCustomerTypeCount();
		String path=context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "CustomerReports";
	}
}
