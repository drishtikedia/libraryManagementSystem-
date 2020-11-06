package com.kpit.genesis.jdbc.test;
import genesis.jar.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LendingTest {

	@Test
	void test() {
		userRegistration test1=new userRegistration();
		
		
		try {
			
			//lending book to inactive user
				test1.issue_book(33333,1104);
			//lending book to active user
				test1.issue_book(44444,1106);
			//lending unavailable book to user
				test1.issue_book(11111, 1103);
				
				
			
			
			
		}catch(final Exception e) {
			e.printStackTrace();
		}
	}

}
