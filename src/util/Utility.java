package util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utility {
	
	public static String accNoGenerator(String uid, String name)
	{
		long time=System.currentTimeMillis();
		String str=uid.substring(0,2);
		String str2=name.substring(0,2);
		return str+"-"+str2+"-"+time;
	}
	
	public static String pswdEncryption(String pswd) 
	{
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte hash[]=md.digest(pswd.getBytes(StandardCharsets.UTF_8));
		BigInteger num=new BigInteger(1,hash); 
		StringBuilder hexString=new StringBuilder(num.toString(16));
		
		while(hexString.length()<32)
		{
			hexString.insert(0,'0');
		}
		
		return hexString.toString();
	}
}
