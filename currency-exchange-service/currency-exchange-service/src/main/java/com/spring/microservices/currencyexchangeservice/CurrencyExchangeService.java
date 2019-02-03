package com.spring.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

	@Autowired
	ExchangeRepo exchangeRepo;

	public ExchangeValue retriveValues(String from, String to) {
		//exchangeRepo.getByFromCurrencyAndToCurrency(from, to);
		return exchangeRepo.findByFromAndTo(from, to);
	}
}
