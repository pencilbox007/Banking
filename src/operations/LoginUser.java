package operations;

import java.util.ArrayList;

import entity.User;
import storage.UserInfoPool;

public class LoginUser {
	
	public static boolean validateUser(String passedUID, String passedPSWD,int x)
	{
		ArrayList<User> userList=UserInfoPool.userList;
		
		for(int i=0;i<userList.size();i++)
		{
			String storedUID = userList.get(i).uid;
			String storedPSWD = userList.get(i).password;

			if(storedUID.equals(passedUID))
			{
				if(x==1)
				{
					return true;
				}	
				if(storedPSWD.equals(passedPSWD))
				{
					return true;
				}
			}
		}
		return false;
	}

}
