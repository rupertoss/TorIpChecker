package com.rupertoss.toripchecker;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
class TorIpAddr {

	// collection of Tor IP addresses stored as Strings
	private Set<String> torIpSet = new HashSet<>();
	
	private Instant fetchedDate;
	
	Set<String> getTorIpSet() {
		return torIpSet;
	}

	void setTorIpSet(Set<String> torIpSet) {
		this.torIpSet = torIpSet;
	}

	Instant getFetchedDate() {
		return fetchedDate;
	}

	void setFetchedDate(Instant date) {
		fetchedDate = date;
	}
}
