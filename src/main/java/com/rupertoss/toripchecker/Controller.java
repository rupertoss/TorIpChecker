package com.rupertoss.toripchecker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {

	@Autowired
	TorIpAddr torIpAddr;
	
	// Fetches status of application
	// Returns number of tor exit nodes as response body with HTTP status 200
	@GetMapping(value = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusResponse> getStatus() {
		StatusResponse response = new StatusResponse(torIpAddr);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	// Fetches if given A.B.C.D is a tor exit node
	// Returns HttpResponse as body with HTTP status 200 if true, empty body with HTTP status 404 if false
	@GetMapping(value = "/{A.B.C.D}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IpResponse> getTorIpCheck(@PathVariable(value = "A.B.C.D") String request) {
		boolean isTorIp = torIpAddr.isTorIp(request);
		if(isTorIp) {
			IpResponse response = new IpResponse(torIpAddr, request);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
