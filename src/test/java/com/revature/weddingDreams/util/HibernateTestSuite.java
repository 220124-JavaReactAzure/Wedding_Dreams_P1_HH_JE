package com.revature.weddingDreams.util;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.junit.Test;


public class HibernateTestSuite {
	
	// TODO: Implement me like a connection factory test suite
	@Test
	public void test_getSession_returnsValidSessuib_givenProviderCredentials() {
		try {
			Session sess = HibernateUtil.getSession();
			HibernateUtil.closeSession();
			System.out.println(sess);
			assertNotNull(sess);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}