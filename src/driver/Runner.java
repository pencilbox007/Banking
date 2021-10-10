package driver;

import java.util.Scanner;

import entity.User;
import operations.RegisterUser;
import storage.UserInfoPool;

public class Runner {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Input the folowing details");
		System.out.println("USER ID :");
		String uid=sc.nextLine();
		System.out.println("NAME :");
		String name=sc.nextLine();
		System.out.println("PASSWORD");
		String password=sc.nextLine();
		
		RegisterUser user=new RegisterUser();
		String bankAccNo=user.register(uid, name, password);
		System.out.println("Account is succesfully opened");
		System.out.println("Bank Account Number : "+bankAccNo);
		
//		User userInfo=UserInfoPool.user;
//		System.out.println(userInfo.uid);
	}
}
