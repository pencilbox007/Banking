package utility;

public class Utility {
	
	public static String accNoGenerator(String uid, String name)
	{
		long time=System.currentTimeMillis();
		String str=uid.substring(0,2);
		String str2=name.substring(0,2);
		return str+"-"+str2+"-"+time;
	}
}
