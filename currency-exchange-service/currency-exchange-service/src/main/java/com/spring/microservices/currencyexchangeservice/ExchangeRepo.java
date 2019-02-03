package com.spring.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepo extends JpaRepository<ExchangeValue, Integer>{
	ExchangeValue findByFromAndTo(String from, String to);
}
