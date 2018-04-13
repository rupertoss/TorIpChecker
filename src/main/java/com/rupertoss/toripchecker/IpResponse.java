package com.rupertoss.toripchecker;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

class IpResponse {
	
	@JsonProperty("tor_ip_addresses_count")
	private int ipCount;
	
	@JsonProperty("date_of_tor_ip_addresses_data")
	@JsonSerialize(using = InstantSerializer.class)
	private Instant fetchedDate;
	
	@JsonProperty("requested_ip")
	private String ipAddress;
	
	IpResponse(TorIpAddr torIpAddresses, String ipAddress) {
		ipCount = torIpAddresses.getTorIpSetSize();
		fetchedDate = torIpAddresses.getFetchedDate();
		this.ipAddress = ipAddress;
	}
}
