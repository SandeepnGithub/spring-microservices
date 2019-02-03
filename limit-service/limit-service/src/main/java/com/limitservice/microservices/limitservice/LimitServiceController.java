package com.limitservice.microservices.limitservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitServiceController {

	@Autowired
	LimitServiceConfiguration limitServiceConfiguration;

	@GetMapping("/limits")
	public LimitServiceConfiguration getLimits() {
		return limitServiceConfiguration;
	}

}
