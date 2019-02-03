package com.spring.microservices.currencyexchangeservice;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional(readOnly = true)
public class CurrencyExchangeRepoImpl implements CustomRepoCurrencyExchange {
	@PersistenceContext
	EntityManager entityManager;
   
	@Override
	public ExchangeValue getByFromCurrencyAndToCurrency(String from, String to) {
		Query query=entityManager.createNativeQuery("select * from ExchangeValue where fromCurrency=? and toCurrency=? ");
		query.setParameter(1,from);
		query.setParameter(2, to);
		ExchangeValue exchangeValue=(ExchangeValue) query.getResultList().get(0);
		return exchangeValue;
	}


}
