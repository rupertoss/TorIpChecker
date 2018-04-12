package com.rupertoss.toripchecker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IpValidation {

	private static final Pattern ipPattern = Pattern.compile("\\A(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\z");
	
	static boolean isIp(String ipAddress) {
		Matcher matcher = ipPattern.matcher(ipAddress);
		if (matcher.find()) {
			return true;	
		}
		return false;
	}
}
