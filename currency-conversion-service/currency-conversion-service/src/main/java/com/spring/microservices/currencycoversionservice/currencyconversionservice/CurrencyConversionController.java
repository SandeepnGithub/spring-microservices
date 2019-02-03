package com.spring.microservices.currencycoversionservice.currencyconversionservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CurrencyExchangeProxy currencyExchangeProxy;

	@Autowired
	CurrencyConversionService currencyConversionService;

//	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
//	public CurrencyConversionBean getConvertedCurrency(@PathVariable String from, @PathVariable String to,
//			@PathVariable BigDecimal quantity) {
//		RestTemplate restTemplate = new RestTemplate();
//		ExchangeValue exchangeValue = (ExchangeValue) restTemplate.getForObject(
//				"http://localhost:8001/currency-exchange/from/" + from + "/to/" + to, ExchangeValue.class);
//		return currencyConversionService.getConvertedValue(exchangeValue, quantity);
//	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean getConvertedCurrencyUswingFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		logger.info("Entering the Converter feign");
		ExchangeValue exchangeValue=currencyExchangeProxy.retrieveValue(from, to);
		logger.info("Calling the Exchange service"+exchangeValue);
		return currencyConversionService.getConvertedValue(exchangeValue, quantity);
	}
}
