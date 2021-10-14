package storage;

import java.util.ArrayList;

import entity.User;
import utility.Utility;

public class UserInfoPool {

	public static ArrayList<User> userList=new ArrayList<User>();
	
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
}