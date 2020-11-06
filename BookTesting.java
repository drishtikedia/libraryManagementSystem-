package com.kpit.genesis.jdbc.test;
import genesis.jar.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

class BookTesting {

	@Test
	void test() throws SQLException {
		bookRegistration test=new bookRegistration(88888,"A","Lessons",null,null,"Ham");
		test.book_register();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			final Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Library_Management_System","root","Vitee2016,");
			final Statement stmt=connect.createStatement();
			final ResultSet rs=stmt.executeQuery("select * from book where isbn='"+test.isbn+"'");
			
			if(rs.next()) {
				assertEquals(test.isbn,rs.getInt(1));
				assertEquals(test.author,rs.getString(2));
				assertEquals(test.status,rs.getString(3));
				assertEquals(test.return_date,rs.getString(4));
				assertEquals(test.issue_date,rs.getString(5));
				assertEquals(test.title,rs.getString(6));
				
				
			}
			
			
		}catch(final Exception e) {
			e.printStackTrace();
		}
		
		bookRegistration test1=new bookRegistration();
		
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
//			final Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Library_Management_System","root","Vitee2016,");
//			final Statement stmt=connect.createStatement();
//			final ResultSet rs=stmt.executeQuery("select * from book where isbn='"+test1.isbn+"'");
			
				
			
			
			
		}catch(final Exception e) {
			e.printStackTrace();
		}
	}

}
