package com.rupertoss.toripchecker;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IpValidationTest {

	@Test
	public void testIsIp() {
		assertTrue(IpValidation.isIp("123.123.123.123"));
		
		assertFalse(IpValidation.isIp("489.123.123.123"));
		assertFalse(IpValidation.isIp("8A.123.123.123"));
		assertFalse(IpValidation.isIp("123,123,123,123"));
		assertFalse(IpValidation.isIp("String 123.123.123.123"));
	}
}
