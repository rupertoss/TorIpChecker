package com.rupertoss.toripchecker;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

class AbstractionTest {

	TorIpAddr getStubbedTorIpAddr() {
		TorIpAddr stub = new TorIpAddr();
		Set<String> ipSet = new HashSet<>();
		ipSet.add("123.123.123.123");
		ipSet.add("190.190.190.190");
		stub.setTorIpSet(ipSet);
		stub.setFetchedDate(Instant.now());
		return stub;
	}

	
}
