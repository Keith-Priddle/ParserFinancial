package com.moderncloudtech.financial.services;
/**
 * @author Keith Priddle www.moderncloudtech.com
 * @version 0.1d
 */
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moderncloudtech.financial.currency.Currency;

@Service
public class CurrencyServices {

	
	
	public Currency getCurrency() throws IOException {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		JsonNode currencyNode = mapper.readTree(new URL("https://api.exchangeratesapi.io/latest?base=GBP&symbols=EUR"));
		Currency currency = new Currency();	
		currency.setBase(currencyNode.get("base").textValue());
		currency.setDate(currencyNode.get("date").asText());
		System.out.println(currencyNode.get("rates").get("EUR").numberValue());
		BigDecimal rate = currencyNode.get("rates").get("EUR").decimalValue();
		
		System.out.println(rate);
		//Note:: need to use symbols
		return currency;
	}

	
	public Currency getCurrency1() throws IOException{ 
		System.out.println("Running in currency service");
		//String url ="http://api.exchangeratesapi.io/latest?base=GBP&symbols=EUR";
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
		
		Currency currency = mapper.readValue(new URL("https://api.exchangeratesapi.io/latest?base=GBP&symbols=EUR"), Currency.class);
			System.out.println(currency.toString());
		
			
		return currency;
	}
}
