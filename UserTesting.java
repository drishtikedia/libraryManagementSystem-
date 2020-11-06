package com.kpit.genesis.jdbc.test;
import genesis.jar.*;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

class UserTesting {
	@Test
	void testUser() throws SQLException {
		userRegistration  test=new userRegistration(0,1109, "active", "Noel", null, null);
		test.user_register();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			final Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Library_Management_System","root","Vitee2016,");
			final Statement stmt=con.createStatement();
			final ResultSet rs=stmt.executeQuery("select * from user where name='Noel'");
			
			if(rs.next()) {
				assertEquals(test.id,rs.getInt(1));
				assertEquals(test.name,rs.getString(2));
				assertEquals(test.isbn,rs.getInt(3));
				assertEquals(test.status,rs.getString(4));
				assertEquals(test.issue_date,rs.getString(5));
				assertEquals(test.return_date,rs.getString(6));
				
			}
			
			
		}catch(final Exception e) {
			e.printStackTrace();
		}
		userRegistration  test1=new userRegistration(0,1108, "inactive", "Den", null, null);
		//test.user_register();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			final Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Library_Management_System","root","Vitee2016,");
			final Statement stmt=con.createStatement();
			final ResultSet rs=stmt.executeQuery("select * from user where name='abcde'");
			
			if(rs.next()) {
				assertEquals(test1.id,rs.getInt(1));
				assertEquals(test1.name,rs.getString(2));
				assertEquals(test1.isbn,rs.getInt(3));
				assertEquals(test1.status,rs.getString(4));
				assertEquals(test1.issue_date,rs.getString(5));
				assertEquals(test1.return_date,rs.getString(6));
			}
			
			
		}catch(final Exception e) {
			e.printStackTrace();
		}
		
	}

}
