package com.rupertoss.toripchecker;

import com.fasterxml.jackson.annotation.JsonProperty;

class StatusResponse {	
	
	@JsonProperty("tor_ip_addresses_count")
	private int ipCount;
	
	StatusResponse(TorIpAddr torIpAddr) {
		ipCount = torIpAddr.getTorIpSetSize();
	}
}
