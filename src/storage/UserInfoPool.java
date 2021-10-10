package storage;

import entity.User;
import utility.Utility;

public class UserInfoPool {

	public static User user;
	
	public UserInfoPool()
	{
		user=new User();
	}
	public String saveUser(String uid, String name, String password)
	{
		String bankAccNo=Utility.accNoGenerator(uid,name);
		user.bankAccNo=bankAccNo;
		user.uid=uid;
		user.name=name;
		user.password=password;
		return bankAccNo;
	}
}
