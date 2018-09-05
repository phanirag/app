package com.app.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class CoDecUtil {

	//normal to encode
	public String genetareEncode(String normal){
		byte[] arr=Base64.encodeBase64(normal.getBytes());
		return new String(arr);
	}
	
	//encode to normal
	public String genetareDecode(String encoded){
		byte[] arr=Base64.decodeBase64(encoded.getBytes());
		return new String(arr);
	}
}
