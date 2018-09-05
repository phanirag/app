package com.app.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CodeUtil {

	public String generateStr(int size){
		return  UUID
				.randomUUID()
				.toString()
				.replaceAll("-", "")
				.substring(0, size);
	}
	
	public String generatePwd(){
		return generateStr(6);
	}
	
	public String generateToken(){
		return generateStr(8);
	}
}
