package storage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import entity.User;
import util.Utility;

public class UserInfoPool {

	public static String filePath="C:\\Users\\Anurag Halder\\eclipse-workspace\\Banking\\src\\files\\UserInfo.txt";
	public static List<User> userList=new ArrayList<User>();
	static Gson gson=new Gson();
	
	public String saveUser(String uid, String name, String password)
	{
		String bankAccNo=Utility.accNoGenerator(uid,name);
		User user=new User();
		user.bankAccNo=bankAccNo;
		user.uid=uid;
		user.name=name;
		user.password=password;
		
		userList.add(user);
		
		return bankAccNo;
	}
	
	public int getUserCount()
	{
		return userList.size();
	}
	
	public static String objectToJson()
	{
		String json=gson.toJson(userList);
		return json;
	}
	
	public List<User> jsonToObject(String json)
	{
		Type listType = new TypeToken<List<User>>(){}.getType();
		return gson.fromJson(json,listType); 
	}
	public static void readFile() throws FileNotFoundException
	{
		FileReader reader = new FileReader(filePath);
	}
	public static void writeFile() throws IOException
	{
		String str=UserInfoPool.objectToJson();
		FileWriter writer = new FileWriter(filePath);
		writer.write(str);
		writer.close();
	}
}