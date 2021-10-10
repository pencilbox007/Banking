package operations;

import entity.User;
import storage.UserInfoPool;

public class LoginUser {
	
	public static boolean validateUser(String uid, String pswd)
	{
		User user=UserInfoPool.user;
		if(uid.equals(user.uid) &&  pswd.equals(user.password))
		{
			return true;
		}
		return false;
	}

}
