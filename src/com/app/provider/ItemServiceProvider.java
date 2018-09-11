package com.app.provider;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.model.Item;
import com.app.service.ICustomerService;
import com.app.service.IItemService;
import com.app.validator.CustomerValidator;

@Component
@Path("/Item")
@XmlRootElement
@Consumes("application/json")
@Produces("application/json")
public class ItemServiceProvider {
	
	@Autowired
	private IItemService service;
	
	@Autowired
	private ICustomerService custservice;
	
	@Autowired
	private CustomerValidator validator;
	
	
	@POST
	@Path("/Save")
	public Response SaveItem(
				@HeaderParam("userName")String userName,
				@HeaderParam("Password")String Password,
				@HeaderParam("Token")String Token,
				Item itemJson){
		// 1.basic input validations
		if(userName==null ||"".equals(userName.trim()))
			return Response.status(Response.Status.BAD_REQUEST).build();
			//return "UserName Cannot be Empty or Null";
		if(Password==null ||"".equals(Password.trim()))
			return Response.status(Response.Status.BAD_REQUEST).build();
			//return "Password Cannot be Empty or Null";
		if(Token==null ||"".equals(Token.trim()))
			return Response.status(Response.Status.BAD_REQUEST).build();
			//return "Token Cannot be Empty or Null";
		if(itemJson==null)
			return Response.status(Response.Status.BAD_REQUEST).build();
			//return "item(Json) Cannot be Empty or Null";
		
		// 2. user name(Customer exist) check
		Customer cust=custservice.getCustomerByEmail(userName);
		if(cust==null)
			//return "Invalid UserName(Customer does not exist)";
			return Response.status(Response.Status.BAD_REQUEST).build();

			
		// 3. Request pwd,token matching with DB pwd,token
		boolean isValid=validator.isPwdAndTokenValid(Password, Token, cust);
		if(!isValid)
			//return "Password and Token are not Valid";
			return Response.status(Response.Status.BAD_REQUEST).build();

		// 4. Customer type should be Seller
			isValid=validator.isCustTypeSellet(cust);
			if(!isValid)
				//return "Customer Type is not 'seller' to perform this operation";
				return Response.status(Response.Status.BAD_REQUEST).build();

		// 5.consider current customer is Item obj customer or link custId with ItemCustId
			itemJson.setCustId(cust.getCustId());
		// 6.save item object
			@SuppressWarnings("unused")
			int itemId=service.saveItem(itemJson);

		//return "Item Saved Successfully with Id:"+itemId;
			return Response.ok().build();

	}
	
	@DELETE
	@Path(value="/deleteItem/{id}")
	public Response deleteItemById(@PathParam("id")int id){
		service.deleteItem(id);
		return Response.ok().build();
	}
	
	@PUT
	@Path(value="/updateItem/{id}")
	public Response updateByid(@PathParam("id")int id,Item item){
		service.updateItem(item);
		return Response.ok().build();
	}
	
	@GET
	@Path(value="/GetId/{id}")
	@Produces("application/json")
	public Response OrderSend(@PathParam("id")int id){
		Item i=service.getItembyid(id);
		if(i==null){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok(i).build();
	}
	
	@GET
	@Path(value="/GetAll")
	@Produces("application/json")
	public Response OrderSendAll(){
		List<Item> i=service.getallItem();
		if(i==null){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok(i).build();
	}
}
