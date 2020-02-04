package com.moderncloudtech.financial.currency;
/**
 * @author Keith Priddle www.moderncloudtech.com
 * @version 0.1d
 */
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



@Component
@JsonIgnoreProperties(ignoreUnknown=true)
public class Currency {

	@JsonProperty("rates")
	private Rates rates;
	
	private String base;
	
	//@JsonDeserialize(using = LocalDateDeserializer.class)  
	//@JsonSerialize(using = LocalDateSerializer.class) 
	//@JsonIgnore
	private String date;

	//@JsonProperty("currency")
	private String currency;
	
	//@JsonProperty("rate")
	
	private BigDecimal rate;
	
	private String textRate;
	
	
	public Currency() {}
	
	
	
	public Currency(Rates rates, String base, String date) {
		super();
		this.rates = rates;
		this.base = base;
		this.date = date;
	}

	


	public String getTextRate() {
		return textRate;
	}



	public void setTextRate(String textRate) {
		this.textRate = textRate;
	}



	public Rates getRates() {
		return rates;
	}

	public void setRates(Rates rates) {
		this.rates = rates;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	


	public String getCurrency() {
		return currency;
	}



	public void setCurrency(String currency) {
		this.currency = currency;
	}



	public BigDecimal getRate() {
		return rate;
	}



	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Currency [rates=");
		builder.append(rates);
		builder.append(", base=");
		builder.append(base);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}
	
//	@SuppressWarnings("unchecked")
//    @JsonProperty("rates")
//    private void unpackNested(Map<String,Object> brand) {
//        this.brandName = (String)brand.get("name");
//        Map<String,String> owner = (Map<String,String>)brand.get("owner");
//        this.ownerName = owner.get("name");
//    }
}
