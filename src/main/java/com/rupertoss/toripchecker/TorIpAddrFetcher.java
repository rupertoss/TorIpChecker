package com.rupertoss.toripchecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
class TorIpAddrFetcher {
	
	private static final long fetchInterval = 30*60*1000; // 30min
	private static final String torIpUrl = "https://check.torproject.org/exit-addresses";
	
	@Autowired
	TorIpAddr torIpAddr;
	
	TorIpAddrFetcher(TorIpAddr torIpAddr) {
		this.torIpAddr = torIpAddr;
	}
	
	@Scheduled(fixedRate = fetchInterval)
	void updateTorIpAddresses() throws IOException {
		torIpAddr.setTorIpSet(fetchTorIpAddresses());
        torIpAddr.setFetchedDate(Instant.now());
	}
	
	private Set<String> fetchTorIpAddresses() throws IOException {
		Set<String> fetchedTorIpAddresses = new HashSet<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(torIpUrl).openStream()))) {
	        
			String inputLine;
			
	        while ((inputLine = br.readLine()) != null) {			// fetch each line
	    		String [] inputParts = inputLine.split(" ");		// split in separate words
	    		for (int i = 0; i < inputParts.length; i++) {
	    			if (IpValidation.isIp(inputParts[i])) {
	    				fetchedTorIpAddresses.add(inputParts[i]);	// add to set if is IP
	    			}
	    		}
	        }
		} catch (IOException exception) {
			throw new IOException("Could not fetch Tor IP addresses");
		}
		return fetchedTorIpAddresses;
	}
}
