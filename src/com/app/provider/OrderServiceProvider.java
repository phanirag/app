package com.app.provider;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.model.Order;
import com.app.service.ICustomerService;
import com.app.service.IOrderService;
import com.app.util.JSONUtil;
import com.app.validator.CustomerValidator;

@Component
@Path("/Order")
public class OrderServiceProvider {
	
	@Autowired
	private IOrderService service;
	
	@Autowired
	private ICustomerService custservice;
	
	@Autowired
	private CustomerValidator validator;
	
	@Autowired
	private JSONUtil JsonUtil;
	
	@POST
	@Path("/Save")
	public String SaveOrder(@HeaderParam("userName")String userName,
			@HeaderParam("Password")String Password,
			@HeaderParam("Token")String Token,
			String orderJson){
	// 1.basic input validations
	if(userName==null ||"".equals(userName.trim()))
		return "UserName Cannot be Empty or Null";
	if(Password==null ||"".equals(Password.trim()))
		return "Password Cannot be Empty or Null";
	if(Token==null ||"".equals(Token.trim()))
		return "Token Cannot be Empty or Null";
	if(orderJson==null ||"".equals(orderJson.trim()))
		return "item(Json) Cannot be Empty or Null";
	
	// 2. user name(Customer exist) check
	Customer cust=custservice.getCustomerByEmail(userName);
	if(cust==null)
		return "Invalid UserName(Customer does not exist)";
	
	// 3. Request pwd,token matching with DB pwd,token
	boolean isValid=validator.isPwdAndTokenValid(Password, Token, cust);
	if(!isValid)
		return "Password and Token are not Valid";

	// 4. Customer type should be Consumer
		isValid=validator.isCustTypeConsumer(cust);
		if(!isValid)
			return "Customer Type is not 'Consumer' to perform this operation";
		
	// 5.Convert input JSON to object(Order)
		Object ob=JsonUtil.convertJsonToObject(orderJson, Order.class);
		if(ob==null)
			return "Invalid Order(JSON) Detailes";
		Order order=null;
		if(ob instanceof Order)
			order=(Order)ob;
	
	// 6.Link custId with Order custID
		order.setCustId(cust.getCustId());
	
	//	7.Save Order Object
		int Orderid=service.saveOrder(order);
		
		return "Order Saved Successfully with ID: "+Orderid;
	}
}
