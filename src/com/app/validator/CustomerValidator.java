package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.util.CoDecUtil;

@Component
public class CustomerValidator {

	@Autowired
	private CoDecUtil codec;
	
	public boolean isCustTypeConsumer(Customer cust){
		return "Consumer".equalsIgnoreCase(cust.getCustType());
	}
	
	public boolean isCustTypeSellet(Customer cust){
		return "Seller".equalsIgnoreCase(cust.getCustType());
	}
	
	public boolean isPwdAndTokenValid(String reqPwd,String reqToken,Customer cust){
		boolean flag=false;
		
		//Get enCoded password and Token from DB
		String enPwd=cust.getPassword();
		String enToken=cust.getAccToken();
		
		//Decode Pwd and Token
		String dbPwd=codec.genetareDecode(enPwd);
		String dbToken=codec.genetareDecode(enToken);

		//Compare decoded values with requested Pwd and Token
		flag=reqPwd.equals(dbPwd)&& reqToken.equals(dbToken);
		
		return flag;
	}
	
}
