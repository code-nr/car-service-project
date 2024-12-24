package com.gqt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private String username;
	private String password;
	private String email;
	
	Connection con=null;

	public Customer(String name, String username, String password, String email) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Customer() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	{
		try {
			 DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gqt_november","root","1433");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public int customerRegister()
	{
		try
		{
			String s="insert into customer values(?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setString(1, name);
			pstmt.setString(2, username);
			pstmt.setString(3, password);
			pstmt.setString(4, email);
			int rows=pstmt.executeUpdate();
			return rows;
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	public int customerLogin()
	{
		try
		{
			String s="select  * from customer where username=?";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setString(1, username);
			ResultSet res=pstmt.executeQuery();
			
			if(res.next()) 
	    	  {
	    		  if(res.getString(3).equals(password))
	    		  {
	    			 name=res.getString(1);
	    			 return 1; //valid credentials
	    		  }
	    		  else
	    		  {
	    			  return -1;//invalid password
	    		  }
	    	  }
	    	  else
	    	  {
	    		  return 0;
	    	  }	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	public String toString() {
		return "Customer [name=" + name + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}

	public List<Customer> viewCustomers() {
		try 
		{
			ArrayList<Customer> customerList=new ArrayList<>();
			String s="select * from customer";
			Statement stmt=con.createStatement();
			ResultSet res=stmt.executeQuery(s);
			while(res.next())
			{
				name=res.getString(1);
				username=res.getString(2);
				password=res.getString(3);
				email=res.getString(4);
				Customer c=new Customer(name,username,password,email);
				customerList.add(c);		
			}
			return customerList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}	
}
