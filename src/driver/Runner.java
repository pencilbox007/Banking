package driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import entity.User;
import operations.LoginUser;
import operations.RegisterUser;
import storage.UserInfoPool;
import utility.ResponseMessage;

public class Runner {

	static Scanner sc=new Scanner(System.in);
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String args[]) throws IOException
	{
		while(true)
		{
			System.out.println("======================================Welcome to ANURAG'S BANKING SYSTEM======================================");
			System.out.print("Type 1 for REGISTRATION or 2 for LOGIN or 3 for EXIT :");
			int num=sc.nextInt();
			if(num==1)
			{
				Runner.register();
			}
			else if(num==2)
			{
				Runner.login();
			}
			else if(num==3)
			{
				System.out.println("THANKS FOR USING");
				System.exit(0);
			}
		}
	}
	
	public static void register() throws IOException
	{
		RegisterUser registerUser=new RegisterUser();
		
		System.out.println("====================REGISTRATION====================");
		System.out.println("Input the folowing details");
		System.out.print("USER ID :");
		String uid=br.readLine();
		
		String responseMsg=registerUser.checkUIDrules(uid);
		if(!(responseMsg.equals(ResponseMessage.UID_VALID)))
		{
			System.out.println("ERROR : "+responseMsg);
			register();
		}
		
		System.out.print("NAME :");
		String name=br.readLine();
		System.out.print("PASSWORD :");
		String password=br.readLine();
		
		String bankAccNo=registerUser.register(uid, name, password);
		System.out.println("=============================================");
		System.out.println("Account is succesfully opened");
		System.out.println("Bank Account Number : "+bankAccNo);
		
		System.out.println("Would you like to login.Type YES or NO");
		String str=sc.next();
		if(str.equals("YES"))
		{
			Runner.login();
		}
	}
	
	public static void login()
	{
		System.out.println("====================LOGIN====================");
		boolean c=false;
		System.out.print("USER ID :");
		String input_uid=sc.next();
		System.out.print("PASSWORD :");
		String input_pswd=sc.next();
		
		c=LoginUser.validateUser(input_uid,input_pswd);
		
		if(c)
		{
			System.out.println("Access Granted");
		}
		else
		{
			System.out.println("Acces Denied");
		}
	}
}
