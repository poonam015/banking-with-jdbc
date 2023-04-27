package com.BankingPro;

import java.util.*;

public class BankingMain {

	public static void main(String[] args) throws Exception {
	
		Scanner ps=new Scanner(System.in);
		BankingDao dao=new BankingDao();
		Customers c1=new Customers();
		
		System.out.println("\t\t\t********Welcome to JDBC Bank***********");
		
		System.out.println("Press 1 for Registration \nPress 2 for Login");
		int op=ps.nextInt();
		
		switch(op) {
		
		case 1-> {
			System.out.println("Enter Customer Id");
			int cid=ps.nextInt();
			ps.nextLine();
			System.out.println("Enter Customer Name");
			String cname=ps.nextLine();
			System.out.println("Enter Customer Pin");
			int cpin=ps.nextInt();
			System.out.println("Enter Customer Account Amount");
			int camount=ps.nextInt();

			c1.CusID=cid;
			c1.CusName=cname;
			c1.CusPin=cpin;
			c1.CusAmount=camount;
			
			//getting connection to db
			dao.dbconnection();
			//inserting user details into db
			int res=dao.registercustomer(c1);
			
			//if insertion is success response is 1 otherwise 0
			if(res==1) {
				System.out.println("Account creation successfully");
			}
			else {
				System.out.println("Something went wrong");
			}

		}
		case 2-> {
			System.out.println("Welcome to Login Page");
			//reading username and password for login
			System.out.println("Enter Username");
			ps.nextLine();
			String uname=ps.nextLine();
			System.out.println("Enter Password");
			int pwd=ps.nextInt();
			
			//connecting to db
			dao.dbconnection();
			
			//login method
			int res=dao.login(uname, pwd);
			//handling the response
			if(res==0) {
				System.out.println("username/password are incorrect");
			}
			else if(res==-1) {
				System.out.println("Unable to find the details");
			}
			else {
				System.out.println("Login successful");
				System.out.println("Press 1 for Deposit\nPress 2 for Withdraw\nPress 3 for change password\nPress 4 for Delete Account");
				int ops=ps.nextInt();
				switch(ops) {
				
				case 1-> {
					System.out.println("Enter amount to Deposit");
					int amount=ps.nextInt();
					int bal=dao.deposit(amount,res);
					System.out.println("Depsoit successful\n Available Amount is :"+bal);
				
				}
				case 2-> {
					System.out.println("Enter amount to Withdraw");
					int amount=ps.nextInt();
					System.out.println("Confirm Your Password");
					int comfpwd=ps.nextInt();
					int availamount=dao.withdraw(amount, comfpwd, res);
					if(availamount==-1) {
						System.out.println("Low Balance");
					}
					else if(availamount==0) {
						System.out.println("Incorrect Password");
					}
					else {
					System.out.println("Withdraw successful\n Available Amount is :"+availamount);	
					}
				}
				case 3->{
					System.out.println("Enter current password");
					int currentpwd=ps.nextInt();
					System.out.println("Enter new password");
					int newpwd=ps.nextInt();
					
					int status=dao.changepwd(currentpwd, newpwd, res);
					if(status==1) {
						System.out.println("Password changed...");
					}
					else {
						System.out.println("Something went wrong");
					}
					
			}
				case 4->{
					System.out.println("Enter password to delete");
					int pass=ps.nextInt();
					int status=dao.DeleteAccount(pass, res);
					if(status==1) {
						System.out.println("Your account is deleted\n Good Bye!....");
					}
					else {
						System.out.println("Something went wrong");
					}
					
					
					
					
					
			}
			
			
			}
		
		
		
		
		}
		
	}
	
	
	
	}
	
	
	
	ps.close();
	
				}
				
			}

