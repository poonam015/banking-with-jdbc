package com.BankingPro;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest{
	BankingDao p1=new BankingDao();
	
//			@Test
	//		public void testlogin() throws Exception{
		//		p1.dbconnection();
			//	int exp=101;
			//	int res=p1.login("Poonam", 7060); //res is actual value from login
			//	assertEquals(exp,res);
			//}
			
		//	@Test
			//negative test case
		//	public void testlogin2()throws Exception {
		//		p1.dbconnection();
		//		int exp=101;
		//		int res=p1.login("Poonam", 7060); //res is actual value from login
		//		assertEquals(exp,res);
		//	}
			
		//	@Test
			//negative with wrong password
		//	public void testlogin3()throws Exception {
		//		p1.dbconnection();
		//		int exp=101;
			//	int res=p1.login("Poonam", 7064); //res is actual value from login
		//		assertEquals(exp,res);
		//	}
	
	@Test
	public void testdeposit()throws Exception {
		p1.dbconnection();
		int exp=50000;
		int availableamount=p1.deposit(1000, 101);
		assertEquals(exp,availableamount);
		}
	
//	@Test
	//positive withdraw test case
//	public void testwithdraw()throws Exception {
//		p1.dbconnection();
//		int exp=52000;
//		int amt=p1.withdraw(1000,7060, 101);
//		assertEquals(exp,amt);
//		}
	
//	@Test
	//negative withdraw test case
//	public void testwithdraw1()throws Exception {
//		p1.dbconnection();
//		int exp=52000;
//		int amt=p1.withdraw(75000,7060, 101);
//		assertNotEquals(exp,amt);
//		}
	
	@Test
	//change password of customer login
	public void testpwd()throws Exception {
		
		p1.dbconnection();
		int exp=1;
		int res=p1.changepwd(7060,7080, 101);
		assertEquals(exp,res);
		}
	
	@Test
	//delete account
	public void testdel()throws Exception {
		
		p1.dbconnection();
		int exp=1;
		int act=p1.DeleteAccount(4455, 103);
		assertEquals(exp,act);
		}
	
	@Test
	//new register for customer
	public void testregister()throws Exception {
		
		Customers c1=new Customers();
		c1.CusID=103;
		c1.CusName="golu";
		c1.CusPin=4455;
		c1.CusAmount=44000;
		
		int exp=3;
		p1.dbconnection();
		int act=p1.registercustomer(c1);
		assertEquals(exp,act);
		}
}