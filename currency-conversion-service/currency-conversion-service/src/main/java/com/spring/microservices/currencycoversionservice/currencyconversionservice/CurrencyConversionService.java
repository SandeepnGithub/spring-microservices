package com.spring.microservices.currencycoversionservice.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService {
   
	public CurrencyConversionBean getConvertedValue(ExchangeValue exchangeValue,BigDecimal quantity){
		CurrencyConversionBean conversionBean=new CurrencyConversionBean(exchangeValue.getId(),exchangeValue.getFrom(),exchangeValue.getTo(),exchangeValue.getConversionMultiple(),quantity,exchangeValue.getConversionMultiple().multiply(quantity));
		return conversionBean;
	}
}
