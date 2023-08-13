package VTIGER.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgPractice 
{
	@Test(invocationCount=2,priority=0)
	public void createuser() 
	{
		Assert.fail();
		System.out.println("create user");
		
	}
	
	@Test(dependsOnMethods="createuser")
	public void modifyuser() 
	{
		System.out.println("modify user");
		
	}
	
	@Test(enabled=false)
	public void Deleteeuser() 
	{
		System.out.println("delete user");
		
	}

}
