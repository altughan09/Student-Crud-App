package com.test.testdb;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/masterdata_db?useSSL=false";  
	    String kullanici = "root";
	    String sifre = "";
	    
		try {
			System.out.println("Connecting to database: "+url);
			Connection conn = DriverManager.getConnection(url,kullanici,sifre);
			System.out.println("Connection successful!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
