package com.app.provider;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.model.Order;
import com.app.service.ICustomerService;
import com.app.service.IOrderService;
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
	
	
	@POST
	@Path("/Save")
	public String SaveOrder(@HeaderParam("userName")String userName,
			@HeaderParam("Password")String Password,
			@HeaderParam("Token")String Token,
			Order orderJson){
	// 1.basic input validations
	if(userName==null ||"".equals(userName.trim()))
		return "UserName Cannot be Empty or Null";
	if(Password==null ||"".equals(Password.trim()))
		return "Password Cannot be Empty or Null";
	if(Token==null ||"".equals(Token.trim()))
		return "Token Cannot be Empty or Null";
	if(orderJson==null)
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
		

	
	// 6.Link custId with Order custID
		orderJson.setCustId(cust.getCustId());
	
	//	7.Save Order Object
		int Orderid=service.saveOrder(orderJson);
		
		return "Order Saved Successfully with ID: "+Orderid;
	}
	
	
	@GET
	@Path(value="/GetId/{id}")
	@Produces("application/json")
	public Response OrderSend(@PathParam("id")int id){
		Order o=service.getOrderById(id);
		if(o==null){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok(o).build();
	}
	
	@GET
	@Path(value="/GetAll")
	@Produces("application/json")
	public Response OrderSendAll(){
		List<Order> o=service.getAllOrder();
		if(o==null){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok(o).build();
	}
	
}
