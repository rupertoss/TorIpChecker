package com.rupertoss.toripchecker;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
class TorIpData {

	// collection of Tor IP addresses stored as Strings
	private static Set<String> torIpSet = new HashSet<>();
	
	private static Instant fetchedDate;
	
	static Set<String> getTorIpSet() {
		return torIpSet;
	}

	static Instant getFetchedDate() {
		return fetchedDate;
	}

	static void setFetchedDate(Instant date) {
		fetchedDate = date;
	}
}
