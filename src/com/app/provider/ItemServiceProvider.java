package com.app.provider;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.model.Item;
import com.app.service.ICustomerService;
import com.app.service.IItemService;
import com.app.util.JSONUtil;
import com.app.validator.CustomerValidator;

@Component
@Path("/Item")
public class ItemServiceProvider {
	
	@Autowired
	private IItemService service;
	
	@Autowired
	private ICustomerService custservice;
	
	@Autowired
	private CustomerValidator validator;
	
	@Autowired
	private JSONUtil JsonUtil;
	
	@POST
	@Path("/Save")
	public String SaveItem(
				@HeaderParam("userName")String userName,
				@HeaderParam("Password")String Password,
				@HeaderParam("Token")String Token,
				String itemJson){
		// 1.basic input validations
		if(userName==null ||"".equals(userName.trim()))
			return "UserName Cannot be Empty or Null";
		if(Password==null ||"".equals(Password.trim()))
			return "Password Cannot be Empty or Null";
		if(Token==null ||"".equals(Token.trim()))
			return "Token Cannot be Empty or Null";
		if(itemJson==null ||"".equals(itemJson.trim()))
			return "item(Json) Cannot be Empty or Null";
		
		// 2. user name(Customer exist) check
		Customer cust=custservice.getCustomerByEmail(userName);
		if(cust==null)
			return "Invalid UserName(Customer does not exist)";
		
		// 3. Request pwd,token matching with DB pwd,token
		boolean isValid=validator.isPwdAndTokenValid(Password, Token, cust);
		if(!isValid)
			return "Password and Token are not Valid";
		
		// 4. Customer type should be Seller
			isValid=validator.isCustTypeSellet(cust);
			if(!isValid)
				return "Customer Type is not 'seller' to perform this operation";

		// 5.convert input JSON to object(Item)
			Object ob=JsonUtil.convertJsonToObject(itemJson, Item.class);
			if(ob==null)
				return "Invalid Item(JSON) detailes";
			Item item=null;
			if(ob instanceof Item)
				item=(Item)ob;
		// 6.consider current customer is Item obj customer or link custId with ItemCustId
			item.setCustId(cust.getCustId());
		// 7.save item object
			int itemId=service.saveItem(item);

		return "Item Saved Successfully with Id:"+itemId;
	}
}
