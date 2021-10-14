package operations;

import java.util.ArrayList;

import entity.User;
import storage.UserInfoPool;

public class LoginUser {
	
	public static boolean validateUser(String uid, String pswd)
	{
		ArrayList<User> userList=UserInfoPool.userList;
		
		for(int i=0;i<userList.size();i++)
		{
			if(userList.get(i).uid.equals(uid))
			{
				if(userList.get(i).password.equals(pswd))
				{
					return true;
				}
			}
		}
		return false;
	}

}
