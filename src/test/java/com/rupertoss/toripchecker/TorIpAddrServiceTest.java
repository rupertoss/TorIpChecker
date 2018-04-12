package com.rupertoss.toripchecker;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.Instant;

import org.junit.Test;

public class TorIpAddrServiceTest {
	
	private TorIpAddr torIpAddrStub = new TorIpAddr();
	private TorIpAddrService torIpAddrService = new TorIpAddrService(torIpAddrStub);
	
	@Test
	public void testUpdateTorAddresses() throws Exception {
		torIpAddrService.updateTorIpAddresses();
	
		int size = torIpAddrStub.getTorIpSet().size();
		Instant date = torIpAddrStub.getFetchedDate();
		
		assertTrue(size > 0);
		assertNotNull(date);
	}
}
