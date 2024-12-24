package com.gqt.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Car {
	private String username;
	private String carModel;
	private String carType;
	private String carRegistrationNumber;
	private String serviceRequest;
	private String serviceStatus;
	
	Connection con=null;

	public Car(String username, String carModel, String carType, String carRegistrationNumber, String serviceRequest,
			String serviceStatus) {
		super();
		this.username = username;
		this.carModel = carModel;
		this.carType = carType;
		this.carRegistrationNumber = carRegistrationNumber;
		this.serviceRequest = serviceRequest;
		this.serviceStatus = serviceStatus;
	}

	public Car() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarRegistrationNumber() {
		return carRegistrationNumber;
	}

	public void setCarRegistrationNumber(String carRegistrationNumber) {
		this.carRegistrationNumber = carRegistrationNumber;
	}

	public String getServiceRequest() {
		return serviceRequest;
	}

	public void setServiceRequest(String serviceRequest) {
		this.serviceRequest = serviceRequest;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	@Override
	public String toString() {
		return "Car [username=" + username + ", carModel=" + carModel + ", carType=" + carType
				+ ", carRegistrationNumber=" + carRegistrationNumber + ", serviceRequest=" + serviceRequest
				+ ", serviceStatus=" + serviceStatus + "]";
	}

	{
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gqt_november","root","1433");
		}
		catch(Exception e) {
			e.printStackTrace();		
			}
	}
	public int addCarDetails() {
		try 
		{
			String s="insert into car values(?,?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setString(1,username);
			pstmt.setString(2,carModel);
			pstmt.setString(3,carType );
			pstmt.setString(4,carRegistrationNumber);
			pstmt.setString(5,"null" );
			pstmt.setString(6,"null" );
			int rows=pstmt.executeUpdate();
			return rows;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	public int serviceRequest() {
		String s="update car set service_request=?,service_status=? where username=? and car_registration_number=?";
		PreparedStatement pstmt;
		try 
		{
			pstmt=con.prepareStatement(s);
			pstmt.setString(1,serviceRequest);
			pstmt.setString(2,"Pending...");
			pstmt.setString(3,username);
			pstmt.setString(4,carRegistrationNumber);
			int rows=pstmt.executeUpdate();
			return rows;
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	public int checkStatus() {
		try 
		{
			String s="select * from car where username=? and car_registration_number=?";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setString(1, username);
			pstmt.setString(2, carRegistrationNumber);
			ResultSet res=pstmt.executeQuery();
			if(res.next()) 
			{
				serviceStatus=res.getString(6);
				return 1;
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

	public List<Car> viewCarDetails() {
		try 
		{
			ArrayList<Car> carDetails=new ArrayList<>();
			String s="select * from car";
			Statement stmt=con.createStatement();
			ResultSet res=stmt.executeQuery(s);
			while(res.next())
			{
				
				username=res.getString(1);
				carModel=res.getString(2);
				carType=res.getString(3);
				carRegistrationNumber=res.getString(4);
				serviceRequest=res.getString(5);
				serviceStatus=res.getString(6);
				Car c=new Car(username,carModel,carType,carRegistrationNumber,serviceRequest,serviceStatus);
				carDetails.add(c);		
			}
			return carDetails;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public int editCarDetails() {
		try
		{
			String s="update car set car_type=?,car_model=? where car_registration_number=? and username=?";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setString(1, carType);
			pstmt.setString(2, carModel);
			pstmt.setString(3, carRegistrationNumber);
			pstmt.setString(4, username);
			int rows=pstmt.executeUpdate();
			return rows;	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
		
	}

	public int updateStatus() {
		try 
		{
			String s="update car set service_status=? where username=? and  car_registration_number=?";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setString(1, "completed");
			pstmt.setString(2, username);
			pstmt.setString(3, carRegistrationNumber);
			int rows=pstmt.executeUpdate();
			return rows;
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
		
	}

	
	
	
}
