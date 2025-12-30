package com.test;
abstract class UserData{
	public abstract void display();
}
class OriginalData extends UserData
{
	String username;
	String password;
	
//	String userData=username+" "+password;
	public OriginalData (String user,String pass)
	{
	   this.username=user;
	   this.password=pass;
	}
	@Override
	public void display() {
		System.out.println("Orginal UserData:"+username+" "+password);
	}
}
class ProxyData extends UserData{
	private String username;
	private String password;
	
	private String userData=username+" "+password;
	
	private OriginalData oData=null;
	public ProxyData(String username,String password)
	{
		this.username=username;
		   this.password=password;
	}
	@Override
	public void display() {
		if(oData==null)
		{
			oData=new OriginalData(username,password);
		}
		oData.display();
	}
}
public class ProxyDemo {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         UserData obj1=new OriginalData("username","123");
         obj1.display();
         
	}
 
}
 
 