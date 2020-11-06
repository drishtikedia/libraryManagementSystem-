package com.kpit.genesis.jdbc.test;
import genesis.jar.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchTest {

	@Test
	void test() {
		bookRegistration test1=new bookRegistration();
		
		
		try {
			
			
				test1.book_search(11111);
				test1.book_search(44444);
				
				
			
			
			
		}catch(final Exception e) {
			e.printStackTrace();
		}
	}

}
