package operations;

import storage.UserInfoPool;
import util.Constant;

public class RegisterUser {

	public String register(String uid, String name, String password)
	{
		UserInfoPool user=new UserInfoPool();
		String bankAccNo=user.saveUser(uid, name, password);
		return bankAccNo;
	}
	
	public String checkUIDrules(String uid)
	{
		if(!(uid.length()>5 && uid.length()<15))     
		{
			return Constant.UID_LENGTH_ISSUE;
		}
		if(uid.contains("_"))
		{
			return Constant.UID_UNDERSCORE_ISSUE;
		}
		if(LoginUser.validateUser(uid, null, 1))
		{
			return Constant.UID_AVAILIBILITY_ISSUE;
		}
		return Constant.UID_VALID;	
		
	}
	
}
