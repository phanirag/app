package com.app.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JSONUtil {

	public String convertObjectToJson(Object ob){
		String Json=null;
		try {
			ObjectMapper om=new ObjectMapper();
			Json=om.writeValueAsString(ob);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Json;
	}
	
	@SuppressWarnings("unchecked")
	public Object convertJsonToObject(String Json,@SuppressWarnings("rawtypes") Class clz){
		Object ob=null;
		try {
			ObjectMapper om=new ObjectMapper();
			ob=om.readValue(Json,clz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ob;
	}
}
