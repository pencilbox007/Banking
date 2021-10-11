package operations;

import storage.UserInfoPool;
import utility.ResponseMessage;

public class RegisterUser {

	public String register(String uid, String name, String password)
	{
		UserInfoPool user=new UserInfoPool();
		String bankAccNo=user.saveUser(uid, name, password);
		return bankAccNo;
	}
	
	public String checkUIDrules(String uid)
	{
		if(!(uid.length()>5 && uid.length()<8))
		{
			return ResponseMessage.UID_LENGTH_ISSUE;
		}
		if(uid.contains("_"))
		{
			return ResponseMessage.UID_UNDERSCORE_ISSUE;
		}
		return ResponseMessage.UID_VALID;	
	}
	
}
