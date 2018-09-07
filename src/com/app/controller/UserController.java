package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.User;
import com.app.service.IUserService;
import com.app.util.CodeUtil;
import com.app.util.CommonUtil;

@Controller
public class UserController {
	
	@Autowired
	private IUserService service;
	@Autowired
	private CodeUtil codeUtil;
	@Autowired
	private CommonUtil commonutil;
	
	
	@RequestMapping(value="/regUser")
	public String showreg(ModelMap model){
		model.addAttribute("user",new User());
		return "UserReg";
	}
	
	@RequestMapping(value="/insertUser",method=RequestMethod.POST)
	public String insertUser(@Valid @ModelAttribute("user") User user,BindingResult r,ModelMap map){
		
		if(r.hasErrors()){
			return "UserReg";
		}
		
		String pwd=codeUtil.generatePwd();

		user.setUserPwd(pwd);
		
		int userId=service.saveUser(user);
		
		String msg="User has been created with id"+userId;
		
		String text="Welcome to the User with Id"+userId
				+", and User Name is "+user.getUserEmail()
				+" or "+user.getUserContact()
				+", and password is "+user.getUserPwd();
		
		boolean flag=commonutil.sendmail(user.getUserEmail(), "User Has been Inserted", text);
		if(flag==true){
			msg+="Email also send successfully";
		}
		else{
			msg+="Error while sending Email";
		}
		map.addAttribute("msg",msg);
		return "UserReg";
	}
	
	@RequestMapping(value="/showLogin")
	public String showLogin(){
		return "UserLogin";
	}
	
	@RequestMapping(value="/loginCheck",method=RequestMethod.POST)
	public String checklogin(
			@RequestParam("userName")String userName,
			@RequestParam("Password")String Password,
			ModelMap map,
			HttpServletRequest req){
		String Page=null;
		User user=service.getUserByNameAndPwd(userName, Password);
		if(user==null){			
			map.addAttribute("msg","You have entered wrong UserName/Password");
			Page="UserLogin";
		}
		else{
			HttpSession ses=req.getSession();
			//req.getSession() or req.getSession(true) will create new session
			//req.getSession(false) will get the existing session
			ses.setAttribute("userName", user.getUserName().toUpperCase());
			Page="redirect:regLoc";
		}
		return Page;
	}
	
	@RequestMapping(value="/LogoutUser")
	public String UserLogout(HttpServletRequest req,ModelMap map){
	HttpSession ses=req.getSession(false);// taking existing session
	ses.setAttribute("userName", null);
	ses.invalidate();
	map.addAttribute("msg", "Logout successful");
	return "UserLogin";
		
	}
}
