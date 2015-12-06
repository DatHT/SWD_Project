package com.cathl.icook.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenObj {
	
	public TokenObj() {
		// TODO Auto-generated constructor stub
	}
	
	@JsonProperty("value")
	private String accessToken;
	
	public String getAccessToken() {
		return accessToken;
	}
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
