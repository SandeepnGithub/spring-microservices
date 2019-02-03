package com.spring.microservices.currencycoversionservice.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



//@FeignClient(name="currency-exchange-service"/*,url="localhost:8000"*/)
@FeignClient(name="zuul-filter")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveValue(@PathVariable(value="from") String from,@PathVariable(value="to") String to);
}
