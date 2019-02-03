package com.spring.microservices.currencyexchangeservice;

public interface CustomRepoCurrencyExchange {
	ExchangeValue getByFromCurrencyAndToCurrency(String from, String to);
}
