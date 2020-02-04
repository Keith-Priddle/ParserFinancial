package com.moderncloudtech.financial.currency;
/**
 * @author Keith Priddle www.moderncloudtech.com
 * @version 0.1d
 */
import com.fasterxml.jackson.annotation.JsonProperty;

public class Rates {

	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("rate")
	private Double rate;

	public Rates() {}
	
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}
	
	
}
