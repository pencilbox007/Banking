package storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import entity.User;
import util.Utility;

public class UserInfoPool {
	
	static String str;
	public static String filePath="C:\\Users\\Anurag Halder\\eclipse-workspace\\Banking\\src\\files\\UserInfo.txt";
	public static List<User> userList=new ArrayList<User>();
	static Gson gson=new Gson();
	
	/**
	 * generating account number using provided details 
	 * adding the user object to user list
	 * @throws NoSuchAlgorithmException 
	 */
	public String saveUser(String uid, String name, String password) 
	{
		String bankAccNo=Utility.accNoGenerator(uid,name);
		User user=new User();
		user.bankAccNo=bankAccNo;
		user.uid=uid;
		user.name=name;
		user.password=password;
		
		userList.add(user);
		System.out.println(userList);
		
		return bankAccNo;
	}
	
	/**
	 * finding user count
	 */
	public int getUserCount()
	{
		return userList.size();
	}
	
	/**
	 * converting object to json
	 */
	public static String objectToJson()
	{
		System.out.println("from obj to json"+userList);
		String json=gson.toJson(userList);
		return json;
	}
	
	public static List<User> jsonToObject(String json)
	{
		Type listType = new TypeToken<List<User>>(){}.getType();
		return gson.fromJson(json,listType); 
	}
	
	public static void readUserDetails() throws IOException
	{
		String json=UserInfoPool.readFile();
		userList=UserInfoPool.jsonToObject(json);
	}
	
	public static String readFile() throws IOException
	{
		File file=new File(filePath);
		FileInputStream fis=new FileInputStream(file);
		byte a[]=new byte[(int)file.length()];
		fis.read(a);
		fis.close();
		
		str=new String(a,"UTF-8");
		return str;
	}
	
	public static void writeFile() throws IOException
	{
		String str=UserInfoPool.objectToJson();
		System.out.println(str);
		FileWriter writer = new FileWriter(filePath);
		writer.write(str);
		writer.close();
	}	
}