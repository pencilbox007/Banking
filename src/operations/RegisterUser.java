package operations;

import storage.UserInfoPool;

public class RegisterUser {

	public String register(String uid, String name, String password)
	{
		UserInfoPool user=new UserInfoPool();
		String bankAccNo=user.saveUser(uid, name, password);
		return bankAccNo;
	}
}
