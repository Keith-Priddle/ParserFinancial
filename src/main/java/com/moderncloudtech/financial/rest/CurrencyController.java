package com.moderncloudtech.financial.rest;
/**
 * @author Keith Priddle www.moderncloudtech.com
 * @version 0.1d
 */
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.moderncloudtech.financial.currency.Currency;

@Controller
public class CurrencyController {

	
	//private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//@GetMapping("/currencyrate")
	public Currency convertCurrency() {
	    Map<String, String> uriVariables = new HashMap<>();
	    //uriVariables.put("from", from);
	    //uriVariables.put("to", to);
	    ResponseEntity<Currency> responseEntity = new RestTemplate().getForEntity(
	        "http://api.exchangeratesapi.io/latest?base=GBP&symbols=EUR", Currency.class,
	        uriVariables);
	    Currency response = responseEntity.getBody();
	    return new Currency(response.getRates(), response.getBase(),response.getDate());
	  }
	  
	
	
	
//	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
//	  public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
//	      @PathVariable BigDecimal quantity) {
//	    CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
//	    logger.info("{}", response);
//	    return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
//	        quantity.multiply(response.getConversionMultiple()), response.getPort());
//	  }

	
	
	
	
}
