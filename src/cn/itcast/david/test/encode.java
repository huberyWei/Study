package cn.itcast.david.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class encode {
	public static void main(String[] args)  {
		String urlString ="/content/mms/2016/MMS_SIT/index.html?hello&topic_code=1-1.1-2.12&dsfhk";
		String encode="";
		try {
			encode = URLEncoder.encode(urlString, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String decodeString;
		try {
			decodeString = URLDecoder.decode(encode, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(encode);
	}
}
