package com.spring.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	CurrencyExchangeService currencyExchangeService;
	
	@Autowired
	Environment environment;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveValue(@PathVariable String from,@PathVariable String to){
		logger.info("Entering the ExchangeValue feign");
		ExchangeValue exchangeValue=currencyExchangeService.retriveValues(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		logger.info("Exiting the ExchangeValue feign");
		return exchangeValue;
	}
}
